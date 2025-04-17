import java.util.Scanner;

public class ArrayTargetSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter values of array:");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int target = 5;        
        
    boolean found = false; 
                System.out.println("Pairs that sum to " + target + ":");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + target);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No pairs found that sum to " + target);
        }

        in.close();
    }
}