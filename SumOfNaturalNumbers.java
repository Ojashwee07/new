import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input N
        System.out.print("Enter a positive integer N: ");
        int N = scanner.nextInt();
               int sum = 0;
        int i = 1;
        
              while (i <= N) {
            sum += i;            i++;    
        }
        System.out.println("The sum of the first " + N + " natural numbers is: " + sum);
        scanner.close();
    }
}