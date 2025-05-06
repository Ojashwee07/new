import java.util.HashSet;

public class UnionIntersection {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};

        HashSet<Integer> union = findUnion(array1, array2);
        HashSet<Integer> intersection = findIntersection(array1, array2);

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }

    public static HashSet<Integer> findUnion(int[] arr1, int[] arr2) {
        HashSet<Integer> unionSet = new HashSet<>();

        // Add all elements from the first array
        for (int num : arr1) {
            unionSet.add(num);
        }

        // Add all elements from the second array
        for (int num : arr2) {
            unionSet.add(num);
        }

        return unionSet;
    }

    public static HashSet<Integer> findIntersection(int[] arr1, int[] arr2) {
        HashSet<Integer> intersectionSet = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();

        // Add all elements from the first array to a set
        for (int num : arr1) {
            set1.add(num);
        }

        // Check for common elements in the second array
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }

        return intersectionSet;
    }
}