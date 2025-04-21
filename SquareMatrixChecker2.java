import java.util.Scanner;

public class SquareMatrixChecker2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();
        if (isSquareMatrix(rows, columns)) {
            System.out.println("The matrix is a square matrix.");
            int[][] matrix = new int[rows][columns];
            System.out.println("Enter the elements of the matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print("Element [" + i + "][" + j + "]: ");
                    matrix[i][j] = scanner.nextInt();
                }
            }
            System.out.println("The entered matrix is:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("The matrix is not a square matrix.");
        }

        scanner.close();
    }
    public static boolean isSquareMatrix(int rows, int columns) {
        return rows == columns;
    }
}