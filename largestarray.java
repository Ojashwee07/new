import java.util.Scanner;

public class largestarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter values of array:");
        
       
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            
        }

                int largest = arr[0]; 
        for (int k = 1; k < arr.length; k++) {
            if (arr[k] > largest) {
                largest = arr[k];             }
        }
        System.out.println("The largest value in the array is: " + largest);

        in.close();
    }
}