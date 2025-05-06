public class MoveNegatives {
    public static void main(String[] args) {
        int[] array = {12, -7, 9, -3, 5, -1, 6, -2};
        
        System.out.println("Original array:");
        printArray(array);
        
        moveNegativesToFront(array);
        
        System.out.println("Array after moving negatives to the beginning:");
        printArray(array);
    }

    public static void moveNegativesToFront(int[] arr) {
        int lastNegativeIndex = 0; // Pointer for the last negative number's position

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                // Swap arr[i] with arr[lastNegativeIndex]
                swap(arr, i, lastNegativeIndex);
                lastNegativeIndex++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}