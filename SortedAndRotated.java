public class SortedAndRotated {
    public static void main(String[] args) {
        int[] array1 = {3, 4, 5, 1, 2}; // Sorted and rotated
        int[] array2 = {1, 2, 3, 4, 5}; // Sorted but not rotated
        int[] array3 = {2, 1, 3, 4, 5}; // Not sorted and rotated

        System.out.println("Array 1 is sorted and rotated: " + isSortedAndRotated(array1));
        System.out.println("Array 2 is sorted and rotated: " + isSortedAndRotated(array2));
        System.out.println("Array 3 is sorted and rotated: " + isSortedAndRotated(array3));
    }

    public static boolean isSortedAndRotated(int[] arr) {
        int n = arr.length;
        int count = 0; // To count the number of times the order breaks

        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                count++;
            }
        }

        // The array is sorted and rotated if there is at most one break in order
        return count <= 1;
    }
}