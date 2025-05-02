import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.List;

public class PersonalExpenseTrackerWithPasscode {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginRegisterFrame::new);
    }

    // Utility: SHA-256 hash function
    public static String hashString(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashbytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashbytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not found");
        }
    }

    // Login/Register JFrame
    public static class LoginRegisterFrame extends JFrame {
        private JTextField usernameField;
        private JPasswordField passwordField;
        private final File usersFile = new File("users.txt");

        public LoginRegisterFrame() {
            setTitle("Login or Register");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(350, 230);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));
            panel.setBorder(new EmptyBorder(15, 15, 15, 15));

            usernameField = new JTextField();
            passwordField = new JPasswordField();
            JPasswordField passcodeField = new JPasswordField();

            panel.add(new JLabel("Username:"));
            panel.add(usernameField);
            panel.add(new JLabel("Password:"));
            panel.add(passwordField);
            panel.add(new JLabel("4-digit Passcode (PIN):"));
            panel.add(passcodeField);

            JButton loginButton = new JButton("Login");
            JButton registerButton = new JButton("Register");

            JPanel buttonsPanel = new JPanel(new FlowLayout());
            buttonsPanel.add(loginButton);
            buttonsPanel.add(registerButton);

            Container contentPane = getContentPane();
            contentPane.setLayout(new BorderLayout());
            contentPane.add(panel, BorderLayout.CENTER);
            contentPane.add(buttonsPanel, BorderLayout.SOUTH);

            // Register action - uses username, password, and passcode fields
            registerButton.addActionListener(e -> {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword());
                String passcode = new String(passcodeField.getPassword());

                if (username.isEmpty() || password.isEmpty() || passcode.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill all fields for registration.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!username.matches("[a-zA-Z0-9_]+")) {
                    JOptionPane.showMessageDialog(this, "Username can only contain letters, digits, and underscores.", "Invalid Username", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!passcode.matches("\\d{4}")) {
                    JOptionPane.showMessageDialog(this, "Passcode must be exactly 4 digits.", "Invalid Passcode", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    if (!usersFile.exists()) usersFile.createNewFile();

                    List<String> lines = Files.readAllLines(usersFile.toPath());
                    for (String line : lines) {
                        String[] parts = line.split(":");
                        if (parts.length < 3) continue;
                        if (parts[0].equals(username)) {
                            JOptionPane.showMessageDialog(this, "Username already exists. Choose another.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    try (PrintWriter pw = new PrintWriter(new FileWriter(usersFile, true))) {
                        String passwordHash = hashString(password);
                        String passcodeHash = hashString(passcode);
                        pw.println(username + ":" + passwordHash + ":" + passcodeHash);
                    }
                    JOptionPane.showMessageDialog(this, "Registration successful! You may now login.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Clear fields
                    usernameField.setText("");
                    passwordField.setText("");
                    passcodeField.setText("");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            // Login action - username and password only
            loginButton.addActionListener(e -> {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword());
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter username and password.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!usersFile.exists()) {
                    JOptionPane.showMessageDialog(this, "No users registered yet. Please register first.", "No Users", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try (BufferedReader br = new BufferedReader(new FileReader(usersFile))) {
                    String line;
                    String passwordHash = hashString(password);
                    String storedPasscodeHash = null;
                    boolean foundUser = false;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(":");
                        if (parts.length < 3) continue;
                        if (parts[0].equals(username)) {
                            if (parts[1].equals(passwordHash)) {
                                foundUser = true;
                                storedPasscodeHash = parts[2];
                                break;
                            } else {
                                JOptionPane.showMessageDialog(this, "Incorrect password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }
                    }
                    if (!foundUser) {
                        JOptionPane.showMessageDialog(this, "Username not found.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    // Now prompt for passcode!
                    PasscodePromptFrame passcodePrompt = new PasscodePromptFrame(this, username, storedPasscodeHash);
                    setVisible(false);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error reading users file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            setVisible(true);
        }
    }

    // Passcode prompt after successful login
    public static class PasscodePromptFrame extends JFrame {
        private JPasswordField passcodeField;
        private final String username;
        private final String storedPasscodeHash;
        private final JFrame loginFrame;

        public PasscodePromptFrame(JFrame loginFrame, String username, String storedPasscodeHash) {
            this.loginFrame = loginFrame;
            this.username = username;
            this.storedPasscodeHash = storedPasscodeHash;

            setTitle("Enter 4-digit Passcode");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 150);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new BorderLayout(10,10));
            panel.setBorder(new EmptyBorder(15, 15, 15, 15));
            JLabel label = new JLabel("Enter your 4-digit passcode:");
            passcodeField = new JPasswordField(4);

            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(e -> checkPasscode());

            panel.add(label, BorderLayout.NORTH);
            panel.add(passcodeField, BorderLayout.CENTER);
            panel.add(submitButton, BorderLayout.SOUTH);

            getContentPane().add(panel);

            setVisible(true);
        }

        private void checkPasscode() {
            String entered = new String(passcodeField.getPassword());
            if (!entered.matches("\\d{4}")) {
                JOptionPane.showMessageDialog(this, "Passcode must be exactly 4 digits.", "Invalid Passcode", JOptionPane.ERROR_MESSAGE);
                passcodeField.setText("");
                return;
            }
            String enteredHash = hashString(entered);
            if (enteredHash.equals(storedPasscodeHash)) {
                // Success
                dispose();
                new ExpenseTrackerFrame(username);
                loginFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect passcode. Try again.", "Fail", JOptionPane.ERROR_MESSAGE);
                passcodeField.setText("");
            }
        }
    }

    // Main Expense Tracker Frame (same as before)
    public static class ExpenseTrackerFrame extends JFrame {
        private List<Transaction> transactions = new ArrayList<>();
        private TransactionTableModel tableModel;
        private JLabel incomeLabel;
        private JLabel expenseLabel;
        private JLabel balanceLabel;
        private ChartPanel chartPanel;

        private final File dataFile;
        private final String username;

        public ExpenseTrackerFrame(String username) {
            this.username = username;
            this.dataFile = new File("transactions_" + username + ".txt");

            setTitle("Personal Expense Tracker - User: " + username);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(750, 550);
            setLocationRelativeTo(null);

            JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
            mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            setContentPane(mainPanel);

            JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

            JLabel amountLabel = new JLabel("Amount:");
            JTextField amountField = new JTextField(8);

            JLabel categoryLabel = new JLabel("Category:");
            JTextField categoryField = new JTextField(10);

            JLabel typeLabel = new JLabel("Type:");
            String[] types = {"Income", "Expense"};
            JComboBox<String> typeCombo = new JComboBox<>(types);

            JButton addButton = new JButton("Add");
            JButton deleteButton = new JButton("Delete Selected");
            JButton logoutButton = new JButton("Logout");

            inputPanel.add(amountLabel);
            inputPanel.add(amountField);
            inputPanel.add(categoryLabel);
            inputPanel.add(categoryField);
            inputPanel.add(typeLabel);
            inputPanel.add(typeCombo);
            inputPanel.add(addButton);
            inputPanel.add(deleteButton);
            inputPanel.add(logoutButton);

            mainPanel.add(inputPanel, BorderLayout.NORTH);

            tableModel = new TransactionTableModel();
            JTable table = new JTable(tableModel);
            table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            JScrollPane scrollPane = new JScrollPane(table);
            mainPanel.add(scrollPane, BorderLayout.CENTER);

            JPanel summaryPanel = new JPanel(new BorderLayout(10, 10));
            JPanel labelsPanel = new JPanel(new GridLayout(3, 1));
            incomeLabel = new JLabel("Total Income: ₹0.00");
            expenseLabel = new JLabel("Total Expense: ₹0.00");
            balanceLabel = new JLabel("Balance: ₹0.00");
            incomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
            expenseLabel.setFont(new Font("Arial", Font.BOLD, 14));
            balanceLabel.setFont(new Font("Arial", Font.BOLD, 14));

            labelsPanel.add(incomeLabel);
            labelsPanel.add(expenseLabel);
            labelsPanel.add(balanceLabel);

            summaryPanel.add(labelsPanel, BorderLayout.NORTH);

            chartPanel = new ChartPanel();
            chartPanel.setPreferredSize(new Dimension(250, 170));
            summaryPanel.add(chartPanel, BorderLayout.CENTER);

            mainPanel.add(summaryPanel, BorderLayout.EAST);

            loadTransactions();
            updateSummary();

            addButton.addActionListener(e -> {
                String amountText = amountField.getText().trim();
                String category = categoryField.getText().trim();
                String type = (String) typeCombo.getSelectedItem();

                if (amountText.isEmpty() || category.isEmpty() || type == null) {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double amount;
                try {
                    amount = Double.parseDouble(amountText);
                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(this, "Amount must be positive.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid amount.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Transaction transaction = new Transaction(amount, category, type.equals("Income"));
                transactions.add(transaction);
                tableModel.fireTableDataChanged();
                updateSummary();
                saveTransactions();

                amountField.setText("");
                categoryField.setText("");
            });

            deleteButton.addActionListener(e -> {
                int[] selectedRows = table.getSelectedRows();
                if (selectedRows.length == 0) {
                    JOptionPane.showMessageDialog(this, "Please select at least one transaction to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    transactions.remove(selectedRows[i]);
                }
                table.clearSelection();
                tableModel.fireTableDataChanged();
                updateSummary();
                saveTransactions();
            });

            logoutButton.addActionListener(e -> {
                dispose();
                new LoginRegisterFrame();
            });

            setVisible(true);
        }

        private void updateSummary() {
            double totalIncome = 0;
            double totalExpense = 0;
            for (Transaction t : transactions) {
                if (t.isIncome) {
                    totalIncome += t.amount;
                } else {
                    totalExpense += t.amount;
                }
            }
            double balance = totalIncome - totalExpense;

            incomeLabel.setText(String.format("Total Income: ₹%.2f", totalIncome));
            expenseLabel.setText(String.format("Total Expense: ₹%.2f", totalExpense));
            balanceLabel.setText(String.format("Balance: ₹%.2f", balance));

            chartPanel.setAmounts(totalIncome, totalExpense);
            chartPanel.repaint();
        }

        private void saveTransactions() {
            try (PrintWriter pw = new PrintWriter(new FileWriter(dataFile))) {
                for (Transaction t : transactions) {
                    pw.println(String.format("%.2f,%s,%b", t.amount, escapeCsv(t.category), t.isIncome));
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving transactions: " + e.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private String escapeCsv(String str) {
            if (str.contains(",") || str.contains("\"") || str.contains("\n")) {
                str = str.replace("\"", "\"\"");
                return "\"" + str + "\"";
            }
            return str;
        }

        private void loadTransactions() {
            transactions.clear();
            if (!dataFile.exists()) return;
            try (BufferedReader br = new BufferedReader(new FileReader(dataFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = parseCsvLine(line);
                    if (parts.length == 3) {
                        double amount = Double.parseDouble(parts[0]);
                        String category = parts[1];
                        boolean isIncome = Boolean.parseBoolean(parts[2]);
                        transactions.add(new Transaction(amount, category, isIncome));
                    }
                }
            } catch (IOException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error loading transactions: " + e.getMessage(), "Load Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private String[] parseCsvLine(String line) {
            List<String> tokens = new ArrayList<>();
            boolean inQuotes = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (inQuotes) {
                    if (c == '\"') {
                        if (i + 1 < line.length() && line.charAt(i + 1) == '\"') {
                            sb.append('\"');
                            i++;
                        } else {
                            inQuotes = false;
                        }
                    } else {
                        sb.append(c);
                    }
                } else {
                    if (c == '\"') {
                        inQuotes = true;
                    } else if (c == ',') {
                        tokens.add(sb.toString());
                        sb.setLength(0);
                    } else {
                        sb.append(c);
                    }
                }
            }
            tokens.add(sb.toString());
            return tokens.toArray(new String[0]);
        }

        private class TransactionTableModel extends AbstractTableModel {
            private String[] columns = {"Type", "Category", "Amount"};

            @Override
            public int getRowCount() {
                return transactions.size();
            }

            @Override
            public int getColumnCount() {
                return columns.length;
            }

            @Override
            public String getColumnName(int column) {
                return columns[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Transaction t = transactions.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return t.isIncome ? "Income" : "Expense";
                    case 1:
                        return t.category;
                    case 2:
                        return String.format("₹%.2f", t.amount);
                    default:
                        return "";
                }
            }
        }

        private static class Transaction {
            double amount;
            String category;
            boolean isIncome;

            public Transaction(double amount, String category, boolean isIncome) {
                this.amount = amount;
                this.category = category;
                this.isIncome = isIncome;
            }
        }

        private class ChartPanel extends JPanel {
            private double incomeAmount = 0;
            private double expenseAmount = 0;

            public void setAmounts(double income, double expense) {
                this.incomeAmount = income;
                this.expenseAmount = expense;
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int width = getWidth() - 40;
                int height = getHeight() - 40;
                int x = 20;
                int y = 20;

                double total = incomeAmount + expenseAmount;
                if (total == 0) {
                    g.drawString("No data to display", x + 20, y + height / 2);
                    return;
                }

                int incomeBarWidth = (int) (width * (incomeAmount / total));
                int expenseBarWidth = width - incomeBarWidth;

                g.setColor(new Color(76, 175, 80)); // Green
                g.fillRect(x, y + height / 3, incomeBarWidth, height / 3);
                g.setColor(Color.BLACK);
                g.drawRect(x, y + height / 3, incomeBarWidth, height / 3);
                g.drawString("Income", x + 5, y + height / 3 - 5);
                g.drawString(String.format("₹%.2f", incomeAmount), x + 5, y + height / 3 + height / 3 + 15);

                g.setColor(new Color(244, 67, 54)); // Red
                g.fillRect(x + incomeBarWidth, y + height / 3, expenseBarWidth, height / 3);
                g.setColor(Color.BLACK);
                g.drawRect(x + incomeBarWidth, y + height / 3, expenseBarWidth, height / 3);
                g.drawString("Expense", x + incomeBarWidth + 5, y + height / 3 - 5);
                g.drawString(String.format("₹%.2f", expenseAmount), x + incomeBarWidth + 5, y + height / 3 + height / 3 + 15);
            }
        }
    }
}