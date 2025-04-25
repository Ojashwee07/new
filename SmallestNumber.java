public class SmallestNumber {
    public static int findSmallest(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int smallest = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }
    public static void main(String[] args) {
        int[] numbers = {77, 33, 88, 101, 245};
        int smallestNumber = findSmallest(numbers);
        System.out.println("The smallest number in the array is: " + smallestNumber);
    }
}