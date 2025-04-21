public class Convert {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3, 4},
            {3, 4, 5, 6},
            {4, 5, 6, 7}
        };
        int totalElements = 0;
        for (int i = 0; i < arr.length; i++) {
            totalElements += arr[i].length;
        }
        int[] oneDArray = new int[totalElements];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                oneDArray[index++] = arr[i][j];
            }
        }
        for (int num : oneDArray) {
            System.out.print(num + " ");
        }
    }
}