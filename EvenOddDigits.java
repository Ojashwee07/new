import java.util.ArrayList;
import java.util.List;
public class EvenOddDigits {
    public static void main(String[] args) {
        int number = 123;
        List<Integer> evenDigits = new ArrayList<>();
        List<Integer> oddDigits = new ArrayList<>();
        separateEvenOddDigits(number, evenDigits, oddDigits);
         System.out.println("Even digits: " + evenDigits);
        System.out.println("Odd digits: " + oddDigits);
    }
    public static void separateEvenOddDigits(int number, List<Integer> even, List<Integer> odd) {
        String numStr = String.valueOf(number);
        
        for (char digitChar : numStr.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            if (digit % 2 == 0) {
                even.add(digit);
            } else {
                odd.add(digit);
            }
        }
    }
}