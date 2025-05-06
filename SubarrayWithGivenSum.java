public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int targetSum = 12;

        findSubarrayWithSum(arr, targetSum);
    }

    public static void findSubarrayWithSum(int[] arr, int targetSum) {
        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < arr.length; right++) {
            // Add the current element to the current sum
            currentSum += arr[right];

            // While current sum exceeds the target, move the left pointer
            while (currentSum > targetSum && left <= right) {
                currentSum -= arr[left];
                left++;
            }

            // Check if we found the target sum
            if (currentSum == targetSum) {
                System.out.println("Subarray found between indices " + left + " and " + right);
                return; // Exit after finding the first subarray
            }
        }

        System.out.println("No subarray with the given sum found.");
    }
}