import java.util.Scanner;

public class reversearray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter values of array:");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Array in reverse order:");
        for (int k = arr.length - 1; k >= 0; k--) {
            System.out.println(arr[k]);
        }

        in.close();
    }
}