// import java.util.*;

// public class ReduceExample {
//     public static void main(String[] args) {
//         List<Integer> list = Arrays.asList(5, 10, 15, 20, 25, 30);
//         int sumEven = list.stream()
//                  .filter(x -> x % 2 == 0) 
//                 .reduce(0, (a, b) -> a + b); 
//         System.out.println("Sum of even numbers: " + sumEven);
//     }
// }
// // 2 big
// even and sum 
import java.util.*;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 10, 15, 20, 25, 30);
        
        // Find the maximum number in the list
        Optional<Integer> maxNumber = list.stream()
                                       .reduce(Integer::max);
        if (maxNumber.isPresent()) {
            System.out.println("Maximum number: " + maxNumber.get());
        } else {
            System.out.println("The list is empty.");
        }
    }
}
