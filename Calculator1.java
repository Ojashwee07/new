import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Simple Calculator");
            System.out.println("Enter first number: ");
            double num1 = scanner.nextDouble();
            
            System.out.println("Enter second number: ");
            double num2 = scanner.nextDouble();
            
            System.out.println("Choose an operation: ");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            
            int choice = scanner.nextInt();
            double result;
            
            switch (choice) {
                case 1 -> {
                    result = num1 + num2;
                    System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
                }
                case 2 -> {
                    result = num1 - num2;
                    System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
                }
                case 3 -> {
                    result = num1 * num2;
                    System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
                }
                case 4 -> {
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                }
                default -> System.out.println("Invalid operation selected.");
            }
        }
    }
}