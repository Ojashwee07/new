public class NumberExistence {
    public static boolean doesNumberExist(int[] array, int number) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }
        for (int value : array) {
            if (value == number) {
                return true; 
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 2};
        int numberToCheck = 3;
        boolean exists = doesNumberExist(numbers, numberToCheck);
        if (exists) {
            System.out.println("The number " + numberToCheck + " exists in the array.");
        } else {
            System.out.println("The number " + numberToCheck + " does not exist in the array.");
        }
    }
}