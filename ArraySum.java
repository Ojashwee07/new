public class ArraySum {
    public static void main(String[] args) {
     
        int[] arr = {1, 2, 3, 4, 5};

            int sum = calculateSum(arr);

             System.out.println("The sum of the array is: " + sum);
    }
    public static int calculateSum(int[] array) {
        int sum = 0;         for (int num : array) {
            sum += num; 
        }
        return sum;
    }
}