
import java.util.Scanner;
public class ArrayInput 
{
    public static void main(String[] args){
    try (Scanner in = new Scanner (System.in)) {
        System.out.println("Enter size of arrr");
        int n = in.nextInt();
        int[] arr =new int[n];
        System.out.println("Enter valur of arrr");
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();

        }
        for (int k=0;k<arr.length;k++){
            System.out.println(arr[k]);
        }
    }

}
}
