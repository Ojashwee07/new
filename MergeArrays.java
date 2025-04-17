public class MergeArrays {
    public static void main(String[] args) {
        int[] arr1 = {11, 22};
        int[] arr2 = {33, 44};
        int[] merged = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            merged[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            merged[arr1.length + i] = arr2[i];
        }
        System.out.print("Merged array: ");
        for (int val : merged) {
            System.out.print(val + " ");
        }
    }
}