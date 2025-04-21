public class SquareMatrixPrinter2 {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1, 0},
            {1, 1, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 0, 0}
        };
        printMatrix(matrix);
        
        if (isSquareMatrix(matrix)) {
            System.out.println("The matrix is a square matrix.");
        } else {
            System.out.println("The matrix is not a square matrix.");
        }
        for (int i = 0; i < matrix.length; i++) {
            int zeroCount = countZerosInRow(matrix, i);
            System.out.println("Row " + i + " has " + zeroCount + " zeros.");
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
    public static int countZerosInRow(int[][] matrix, int rowIndex) {
        int count = 0;
        for (int j = 0; j < matrix[rowIndex].length; j++) {
            if (matrix[rowIndex][j] == 0) {
                count++;
            }
        }
        return count;
    }
}