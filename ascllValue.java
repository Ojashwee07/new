import java.util.Scanner;

public class ascllValue {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a character: ");
            char character = scanner.next().charAt(0); 
            int asciiValue = (int) character;
            System.out.println("Character: " + character);
            System.out.println("ASCII value: " + asciiValue);
            // Close the scanner
        }
        }

    }
    
