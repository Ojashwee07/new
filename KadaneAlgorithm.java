public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxSum = findMaxSubarraySum(array);
        System.out.println("Maximum Subarray Sum: " + maxSum);
    }

    public static int findMaxSubarraySum(int[] arr) {
        int maxSoFar = arr[0]; // Initialize to the first element
        int maxEndingHere = arr[0]; // Initialize to the first element

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]); // Update maxEndingHere
            maxSoFar = Math.max(maxSoFar, maxEndingHere); // Update maxSoFar
        }

        return maxSoFar;
    }
}