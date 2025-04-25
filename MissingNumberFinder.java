public class MissingNumberFinder {
    public static int findMissingNumber(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
            int n = array.length + 1; 
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int number : array) {
            actualSum += number;
        }
        return expectedSum - actualSum;
    }
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6};
        int missingNumber = findMissingNumber(numbers);
        System.out.println("The missing number is: " + missingNumber);
    }
}