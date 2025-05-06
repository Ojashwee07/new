import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        List<Integer> intersection = findIntersection(arr1, arr2);
        System.out.println("Intersection of the two arrays: " + intersection);
    }

    public static List<Integer> findIntersection(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both arrays
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++; // Move pointer in arr1
            } else if (arr1[i] > arr2[j]) {
                j++; // Move pointer in arr2
            } else {
                // Found a common element
                result.add(arr1[i]);
                i++;
                j++;
            }
        }

        return result;
    }
}