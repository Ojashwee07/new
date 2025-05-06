public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 0, 0, 0}; // arr1 has extra space for arr2
        int[] arr2 = {2, 4, 6};
        int m = 3; // Number of actual elements in arr1
        int n = arr2.length; // Number of elements in arr2

        merge(arr1, m, arr2, n);

        // Print the merged array
        System.out.print("Merged array: ");
        for (int num : arr1) {
            System.out.print(num + " ");
        }
    }

    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        // Last index of arr1
        int i = m - 1;
        // Last index of arr2
        int j = n - 1;
        // Last index of merged array
        int k = m + n - 1;

        // Merge arr1 and arr2 from the end
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }

        // If there are remaining elements in arr2, copy them
        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }

        // No need to copy the remaining elements of arr1, as they are already in place
    }
}