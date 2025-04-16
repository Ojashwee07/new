import java.util.Scanner;

public class secondlargest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter values of array:");
        
        // Input values into the array
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

       
    int largest = Integer.MIN_VALUE; 
        int secondLargest = Integer.MIN_VALUE; 
       
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] > largest) {
                secondLargest = largest;
                largest = arr[k];
            } else if (arr[k] > secondLargest && arr[k] != largest) {
                secondLargest = arr[k]; 
            }
        }

       
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("There is no second largest value in the array.");
        } else {
       
            System.out.println("The second largest value in the array is: " + secondLargest);
        }

        in.close();     }
}