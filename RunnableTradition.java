// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;

// public class RunnableTradition {
//     public static void main(String[] args) {
//         ArrayList<String> list = new ArrayList<>();
//         list.add("Apple");
//         list.add("Banana");
//         list.add("Cherry");
//         list.add("Date");
//         list.add("Elderberry");

//         Collections.sort(list, new Comparator<String>() {
//             public int compare(String s1, String s2) {
//                 return s1.compareTo(s2);
//             }
//         });

//         // Print the sorted list
//         for (String fruit : list) {
//             System.out.println(fruit);
//         }
//     }
// }
import java.util.ArrayList;
import java.util.Collections;

public class RunnableTradition {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        list.add("Elderberry");

        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));

        list.forEach(System.out::println);
    }
}


