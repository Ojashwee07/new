public class CharacterCheck {
    public static void main(String[] args) {
        char ch = 'A'; // You can change this value to test different characters

        if (ch >= 'A' && ch <= 'Z') {
            System.out.println("Uppercase");
        } else if (ch >= 'a' && ch <= 'z') {
            System.out.println("Lowercase");
        } else {
            System.out.println("Not an alphabet");
        }
    }
}