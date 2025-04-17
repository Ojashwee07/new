public class Sumof2Array {
    public static void main(String[] args) {
       int[] Arr1 = {1, 2, 3, 4, 5};
        int[] Arr2 = {1, 2, 3, 4, 5};


        int[] sumArray = calculateSums(Arr1, Arr2);

      
        System.out.print("The sums of the arrays are: ");
        for (int sum : sumArray) {
         System.out.print(sum + " ");
        }
    }
    public static int[] calculateSums(int[] array1, int[] array2) {
        
        if (array1.length != array2.length) {
        throw new IllegalArgumentException("Arrays must be of the same length");
        }

        int[] sumArray = new int[array1.length]; 
        for (int i = 0; i < array1.length; i++) {
        sumArray[i] = array1[i] + array2[i]; 
        }
        return sumArray; 
    }
}