import java.util.HashSet;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2}; // Example array with a duplicate number

        int duplicate = findDuplicate(arr);
        if (duplicate != -1) {
            System.out.println("The duplicate number is: " + duplicate);
        } else {
            System.out.println("No duplicate number found.");
        }
    }

    public static int findDuplicate(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            // Check if the number has already been seen
            if (seen.contains(num)) {
                return num; // Return the duplicate number
            }
            // Add the number to the set
            seen.add(num);
        }

        return -1; // Return -1 if no duplicate is found
    }
}