public class RotateArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        System.out.println("Original array:");
        printArray(array);

        rotateArrayByOne(array);

        System.out.println("Array after cyclic rotation by one:");
        printArray(array);
    }

    public static void rotateArrayByOne(int[] arr) {
        if (arr.length == 0) return; // Handle empty array case

        int lastElement = arr[arr.length - 1]; // Store the last element

        // Shift elements to the right
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = lastElement; // Place the last element at the first position
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}