public class ArraySumAndMax {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, -3, 0};
        int sum = findSum(arr);
        int max = findMax(arr);
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
    }
    public static int findSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    public static int findMax(int[] arr) {
        int max = arr[0]; 
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}