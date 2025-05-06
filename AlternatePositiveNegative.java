import java.util.ArrayList;
import java.util.List;

public class AlternatePositiveNegative {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, -5, 6};
        int[] rearrangedArray = rearrangeAlternating(arr);
        
        // Print the rearranged array
        for (int num : rearrangedArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] rearrangeAlternating(int[] arr) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        // Separate positive and negative numbers
        for (int num : arr) {
            if (num >= 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        // Create a result array
        int[] result = new int[arr.length];
        int posIndex = 0, negIndex = 0, resultIndex = 0;

        // Alternate between positive and negative numbers
        while (posIndex < positive.size() || negIndex < negative.size()) {
            if (posIndex < positive.size()) {
                result[resultIndex++] = positive.get(posIndex++);
            }
            if (negIndex < negative.size()) {
                result[resultIndex++] = negative.get(negIndex++);
            }
        }

        return result;
    }
}