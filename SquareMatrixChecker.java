import java.util.Scanner;

public class SquareMatrixChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();
        if (isSquareMatrix(rows, columns)) {
            System.out.println("The matrix is a square matrix.");
        } else {
            System.out.println("The matrix is not a square matrix.");
        }
    scanner.close();
    }
    public static boolean isSquareMatrix(int rows, int columns) {
        return rows == columns;
    }
}