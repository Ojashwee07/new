public class MaxMinFinder {
    public static void main(String[] args) {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int[] result = findMaxMin(array);
        
        System.out.println("Maximum: " + result[0]);
        System.out.println("Minimum: " + result[1]);
    }

    public static int[] findMaxMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}; // or throw an exception
        }

        int maxElement = arr[0];
        int minElement = arr[0];

        for (int num : arr) {
            if (num > maxElement) {
                maxElement = num;
            }
            if (num < minElement) {
                minElement = num;
            }
        }

        return new int[]{maxElement, minElement};
    }
}