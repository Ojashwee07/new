public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 0, 1, 2, 1, 0, 2, 1, 0};
        
        System.out.println("Original array:");
        printArray(array);
        
        sortArray(array);
        
        System.out.println("Sorted array:");
        printArray(array);
    }

    public static void sortArray(int[] arr) {
        int low = 0; // Pointer for the next position of 0
        int mid = 0; // Pointer for the current element
        int high = arr.length - 1; // Pointer for the next position of 2

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid]
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    // Swap arr[mid] and arr[high]
                    swap(arr, mid, high);
                    high--;
                    break;
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