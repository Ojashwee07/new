import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println("Multiplication table of " + number + ":");
        for (int i = 1; i <= 10; i++) {
            int product = number * i;
            System.out.print(product + " ");
        }
        scanner.close();
    }
}