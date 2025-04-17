public class FindMaximum {
    public static void main(String[] args) {
        int[] arr1 = {1, 9, 3};
        int[] arr2 = {5, 6, 8};

        int max = Integer.MIN_VALUE;
        for (int val : arr1) {
            if (val > max) {
                max = val;
            }
        }
        for (int val : arr2) {
            if (val > max) {
                max = val;
            }
        }
        System.out.println("Maximum element: " + max);
    }
}