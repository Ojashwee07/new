import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.*;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class PasswordManager extends JFrame {

    private static final String DATA_FILE = "password_manager_data.dat";

    // Data classes
    static class PasswordEntry implements Serializable {
        String site;
        String username;
        byte[] encryptedPassword; // encrypted password bytes

        public PasswordEntry(String site, String username, byte[] encryptedPassword) {
            this.site = site;
            this.username = username;
            this.encryptedPassword = encryptedPassword;
        }
    }

    static class UserData implements Serializable {
        String username;
        byte[] masterPasswordHash; // SHA-256 hash of master password
        byte[] pinHash; // SHA-256 hash of 4-digit pin
        List<PasswordEntry> entries = new ArrayList<>();

        public UserData(String username, byte[] masterPasswordHash, byte[] pinHash) {
            this.username = username;
            this.masterPasswordHash = masterPasswordHash;
            this.pinHash = pinHash;
        }
    }

    private Map<String, UserData> users = new HashMap<>();

    private UserData currentUser;
    private SecretKey currentAESKey; // derived from master password

    // Components
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);

    // Login/Register panel components
    private JTextField loginUserField = new JTextField(15);
    private JPasswordField loginPassField = new JPasswordField(15);

    private JTextField registerUserField = new JTextField(15);
    private JPasswordField registerPassField = new JPasswordField(15);
    private JPasswordField registerPinField = new JPasswordField(4);

    // Password Manager panel components
    private PasswordTableModel passwordTableModel = new PasswordTableModel();
    private JTable passwordTable = new JTable(passwordTableModel);
    private JButton addButton = new JButton("Add Entry");
    private JButton editButton = new JButton("Edit Entry");
    private JButton deleteButton = new JButton("Delete Entry");
    private JButton logoutButton = new JButton("Logout");
    private JButton autofillButton = new JButton("Autofill Password");

    public PasswordManager() {
        super("Secure Password Manager");

        loadUserData();

        createUI();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setResizable(false);

        setVisible(true);
    }

    private void createUI() {
        mainPanel.add(createLoginRegisterPanel(), "LOGIN");
        mainPanel.add(createPasswordManagerPanel(), "MANAGER");

        add(mainPanel);

        cardLayout.show(mainPanel, "LOGIN");
    }

    private JPanel createLoginRegisterPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 20, 0));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Login panel
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBorder(BorderFactory.createTitledBorder("Login"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6,6,6,6);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        loginPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        loginPanel.add(loginUserField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        loginPanel.add(new JLabel("Master Password:"), gbc);
        gbc.gridx = 1;
        loginPanel.add(loginPassField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton loginButton = new JButton("Login");
        loginPanel.add(loginButton, gbc);
        loginButton.addActionListener(e -> doLogin());

        // Register panel
        JPanel registerPanel = new JPanel(new GridBagLayout());
        registerPanel.setBorder(BorderFactory.createTitledBorder("Register"));
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(6,6,6,6);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        registerPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        registerPanel.add(registerUserField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        registerPanel.add(new JLabel("Master Password:"), gbc);
        gbc.gridx = 1;
        registerPanel.add(registerPassField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        registerPanel.add(new JLabel("4-Digit PIN:"), gbc);
        gbc.gridx = 1;
        registerPinField.setDocument(new JTextFieldLimit(4));
        registerPanel.add(registerPinField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton registerButton = new JButton("Register");
        registerPanel.add(registerButton, gbc);
        registerButton.addActionListener(e -> doRegister());

        panel.add(loginPanel);
        panel.add(registerPanel);

        return panel;
    }

    private JPanel createPasswordManagerPanel() {
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        passwordTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        passwordTable.getColumnModel().getColumn(2).setCellRenderer(new PasswordCellRenderer());

        JScrollPane scrollPane = new JScrollPane(passwordTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonsPanel.add(addButton);
        buttonsPanel.add(editButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(autofillButton);
        buttonsPanel.add(logoutButton);

        addButton.addActionListener(e -> addEntry());
        editButton.addActionListener(e -> editEntry());
        deleteButton.addActionListener(e -> deleteEntry());
        logoutButton.addActionListener(e -> logout());
        autofillButton.addActionListener(e -> autofillPassword());

        panel.add(buttonsPanel, BorderLayout.SOUTH);

        return panel;
    }

    // Action handlers

    private void doLogin() {
        String username = loginUserField.getText().trim();
        String pass = new String(loginPassField.getPassword());

        if(username.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter username and master password.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UserData user = users.get(username.toLowerCase());
        if(user == null) {
            JOptionPane.showMessageDialog(this, "User not found. Please register.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            byte[] enteredPassHash = sha256(pass);
            if (!Arrays.equals(enteredPassHash, user.masterPasswordHash)) {
                JOptionPane.showMessageDialog(this, "Incorrect password.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            currentUser = user;
            currentAESKey = generateAESKeyFromPassword(pass);
            passwordTableModel.setEntries(currentUser.entries);
            clearLoginFields();
            cardLayout.show(mainPanel, "MANAGER");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred during login.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void doRegister() {
        String username = registerUserField.getText().trim();
        String pass = new String(registerPassField.getPassword());
        String pin = new String(registerPinField.getPassword());

        if(username.isEmpty() || pass.isEmpty() || pin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(pin.length() != 4 || !pin.matches("\\d{4}")) {
            JOptionPane.showMessageDialog(this, "4-digit PIN must contain exactly 4 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(users.containsKey(username.toLowerCase())) {
            JOptionPane.showMessageDialog(this, "Username already exists. Please choose another.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            byte[] passHash = sha256(pass);
            byte[] pinHash = sha256(pin);

            UserData user = new UserData(username.toLowerCase(), passHash, pinHash);
            users.put(username.toLowerCase(), user);
            saveUserData();

            JOptionPane.showMessageDialog(this, "Registration successful! Please login.", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearRegisterFields();
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred during registration.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addEntry() {
        EntryDialog dialog = new EntryDialog(this, "Add Password Entry", null);
        PasswordEntry entry = dialog.showDialog();
        if(entry != null) {
            currentUser.entries.add(entry);
            passwordTableModel.fireTableDataChanged();
            saveUserData();
        }
    }

    private void editEntry() {
        int selected = passwordTable.getSelectedRow();
        if(selected < 0) {
            JOptionPane.showMessageDialog(this, "Please select an entry to edit.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        PasswordEntry entry = currentUser.entries.get(selected);
        EntryDialog dialog = new EntryDialog(this, "Edit Password Entry", entry);
        PasswordEntry newEntry = dialog.showDialog();
        if(newEntry != null) {
            currentUser.entries.set(selected, newEntry);
            passwordTableModel.fireTableDataChanged();
            saveUserData();
        }
    }

    private void deleteEntry() {
        int selected = passwordTable.getSelectedRow();
        if(selected < 0) {
            JOptionPane.showMessageDialog(this, "Please select an entry to delete.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this entry?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION) {
            currentUser.entries.remove(selected);
            passwordTableModel.fireTableDataChanged();
            saveUserData();
        }
    }

    private void autofillPassword() {
        int selected = passwordTable.getSelectedRow();
        if (selected < 0) {
            JOptionPane.showMessageDialog(this, "Please select an entry to autofill.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Ask for 4-digit PIN
        String pin = JOptionPane.showInputDialog(this, "Enter 4-digit PIN to reveal password:", "PIN Verification", JOptionPane.PLAIN_MESSAGE);
        if(pin == null) return; // cancelled

        if(pin.length() != 4 || !pin.matches("\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Invalid PIN format. Must be 4 numeric digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            byte[] pinHashInput = sha256(pin);
            if(!Arrays.equals(pinHashInput, currentUser.pinHash)) {
                JOptionPane.showMessageDialog(this, "Incorrect PIN.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            PasswordEntry entry = currentUser.entries.get(selected);
            String decrypted = decrypt(entry.encryptedPassword, currentAESKey);

            // Show password to user in safe way
            JTextArea textArea = new JTextArea(3, 20);
            textArea.setText(decrypted);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Password for "+entry.site, JOptionPane.INFORMATION_MESSAGE);

        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error decrypting password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void logout() {
        currentUser = null;
        currentAESKey = null;
        passwordTableModel.setEntries(Collections.emptyList());
        cardLayout.show(mainPanel, "LOGIN");
    }

    private void clearLoginFields() {
        loginUserField.setText("");
        loginPassField.setText("");
    }
    private void clearRegisterFields() {
        registerUserField.setText("");
        registerPassField.setText("");
        registerPinField.setText("");
    }

    // Encryption helpers

    private SecretKey generateAESKeyFromPassword(String password) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] keyBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return new SecretKeySpec(keyBytes, "AES");
    }

    private byte[] encrypt(String plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        // Generate random IV
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        byte[] encrypted = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

        // store IV + ciphertext
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(iv);
        outputStream.write(encrypted);

        return outputStream.toByteArray();
    }

    private String decrypt(byte[] encryptedData, SecretKey key) throws Exception {
        if(encryptedData.length < 16) throw new IllegalArgumentException("Invalid encrypted data");

        byte[] iv = Arrays.copyOfRange(encryptedData, 0, 16);
        byte[] ciphertext = Arrays.copyOfRange(encryptedData, 16, encryptedData.length);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
        byte[] decrypted = cipher.doFinal(ciphertext);

        return new String(decrypted, StandardCharsets.UTF_8);
    }

    private byte[] sha256(String input) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    // Data persistence

    private void loadUserData() {
        File file = new File(DATA_FILE);
        if(file.exists()) {
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Object obj = ois.readObject();
                if(obj instanceof Map) {
                    users = (Map<String, UserData>) obj;
                }
            } catch(Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to load user data. Starting fresh.", "Warning", JOptionPane.WARNING_MESSAGE);
                users = new HashMap<>();
            }
        }
    }

    private void saveUserData() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(users);
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save user data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Table model and cell renderer

    class PasswordTableModel extends AbstractTableModel {

        private final String[] columns = {"Site", "Username", "Password (hidden)"};
        private List<PasswordEntry> entries = Collections.emptyList();

        public void setEntries(List<PasswordEntry> entries) {
            this.entries = entries;
            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return entries.size();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public String getColumnName(int col) {
            return columns[col];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            PasswordEntry e = entries.get(rowIndex);
            switch(columnIndex) {
                case 0: return e.site;
                case 1: return e.username;
                case 2: return "********";
            }
            return "";
        }
        
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    }

    class PasswordCellRenderer extends DefaultTableCellRenderer {
        @Override
        protected void setValue(Object value) {
            if(value != null && value.equals("********")) {
                super.setValue("********");
            } else {
                super.setValue(value);
            }
        }
    }

    // Dialog to add/edit entries

    class EntryDialog extends JDialog {
        private JTextField siteField = new JTextField(20);
        private JTextField usernameField = new JTextField(20);
        private JPasswordField passwordField = new JPasswordField(20);

        private PasswordEntry result = null;

        public EntryDialog(JFrame parent, String title, PasswordEntry toEdit) {
            super(parent, title, true);
            setLayout(new BorderLayout(10,10));
            setResizable(false);

            JPanel fieldsPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(6,6,6,6);
            gbc.anchor = GridBagConstraints.WEST;

            gbc.gridx = 0; gbc.gridy = 0;
            fieldsPanel.add(new JLabel("Site:"), gbc);
            gbc.gridx = 1;
            fieldsPanel.add(siteField, gbc);

            gbc.gridx = 0; gbc.gridy = 1;
            fieldsPanel.add(new JLabel("Username:"), gbc);
            gbc.gridx = 1;
            fieldsPanel.add(usernameField, gbc);

            gbc.gridx = 0; gbc.gridy = 2;
            fieldsPanel.add(new JLabel("Password:"), gbc);
            gbc.gridx = 1;
            fieldsPanel.add(passwordField, gbc);

            add(fieldsPanel, BorderLayout.CENTER);

            JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton okBtn = new JButton("OK");
            JButton cancelBtn = new JButton("Cancel");
            buttonsPanel.add(okBtn);
            buttonsPanel.add(cancelBtn);

            add(buttonsPanel, BorderLayout.SOUTH);

            okBtn.addActionListener(e -> {
                String site = siteField.getText().trim();
                String user = usernameField.getText().trim();
                String pass = new String(passwordField.getPassword());

                if(site.isEmpty() || user.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    byte[] encryptedPass = encrypt(pass, currentAESKey);
                    result = new PasswordEntry(site, user, encryptedPass);
                    setVisible(false);
                } catch(Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Encryption error.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            cancelBtn.addActionListener(e -> {
                result = null;
                setVisible(false);
            });

            if(toEdit != null) {
                siteField.setText(toEdit.site);
                usernameField.setText(toEdit.username);
                try {
                    String decryptedPass = decrypt(toEdit.encryptedPassword, currentAESKey);
                    passwordField.setText(decryptedPass);
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }

            pack();
            setLocationRelativeTo(parent);
        }

        public PasswordEntry showDialog() {
            setVisible(true);
            return result;
        }
    }

    // To limit input length for PIN field
    class JTextFieldLimit extends javax.swing.text.PlainDocument {
        private int limit;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        public void insertString( int offset, String  str, javax.swing.text.AttributeSet attr ) throws javax.swing.text.BadLocationException {
            if (str == null) return;

            if ((getLength() + str.length()) <= limit) {
                if (str.matches("\\d*")) { // allow digits only
                    super.insertString(offset, str, attr);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Use system look and feel for better UI
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ignored) {}

        SwingUtilities.invokeLater(() -> new PasswordManager());
    }
}
