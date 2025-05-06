import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] array = {16, 17, 4, 3, 5, 2};

        List<Integer> leaders = findLeaders(array);
        System.out.println("Leaders in the array: " + leaders);
    }

    public static List<Integer> findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int n = arr.length;

        // Start from the rightmost element
        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight); // The rightmost element is always a leader

        // Traverse the array from right to left
        for (int i = n - 2; i >= 0; i--) {
        if (arr[i] > maxFromRight) {
        leaders.add(arr[i]); // Found a new leader
      maxFromRight = arr[i]; // Update the maximum
        }
        }

        // Reverse the list to maintain the order of leaders
        List<Integer> result = new ArrayList<>();
        for (int i = leaders.size() - 1; i >= 0; i--) {
            result.add(leaders.get(i));
        }

        return result;
    }
}