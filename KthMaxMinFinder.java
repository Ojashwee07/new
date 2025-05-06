import java.util.Arrays;

public class KthMaxMinFinder {
    public static void main(String[] args) {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int k = 3; // Change this value to find different Kth elements

        int kthMax = findKthMax(array, k);
        int kthMin = findKthMin(array, k);

        System.out.println(k + "th Maximum: " + kthMax);
        System.out.println(k + "th Minimum: " + kthMin);
    }

    public static int findKthMax(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length - k]; // Kth max is at the (n-k)th index after sorting
    }

    public static int findKthMin(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1]; // Kth min is at the (k-1)th index after sorting
    }
}