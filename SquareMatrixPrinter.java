public class SquareMatrixPrinter {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {6, 7, 8}
        };
        printMatrix(matrix);
        if (isSquareMatrix(matrix)) {
            System.out.println("The matrix is a square matrix.");
        } else {
            System.out.println("The matrix is not a square matrix.");
        }
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isSquareMatrix(int[][] matrix) {
        return matrix.length > 0 && matrix.length == matrix[0].length;
    }
}