import java.util.HashSet;
public class FindPairsWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int targetSum = 7;
        findPairs(arr, targetSum);
    }
    public static void findPairs(int[] arr, int targetSum) {
        HashSet<Integer> seen = new HashSet<>();
        System.out.println("Pairs with sum " + targetSum + ":");
        for (int num : arr) {
            int complement = targetSum - num;
            // Check if the complement exists in the set
            if (seen.contains(complement)) {
                System.out.println("(" + complement + ", " + num + ")");
            }
            // Add the current number to the set
            seen.add(num);
        }
    }
}