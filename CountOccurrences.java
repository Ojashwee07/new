public class CountOccurrences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 2, 5};
        int elementToCount = 2;
        
        int count = countOccurrences(arr, elementToCount);
        System.out.println("The element " + elementToCount + " occurs " + count + " times.");
    }

    public static int countOccurrences(int[] arr, int element) {
        int count = 0;
        
        // Iterate through the array and count occurrences
        for (int num : arr) {
            if (num == element) {
                count++;
            }
        }
        
        return count;
    }
}