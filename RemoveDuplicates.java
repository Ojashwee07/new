import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
        System.out.println("String after removing duplicates: " + result);
    }

    public static String removeDuplicates(String str) {
        LinkedHashSet<Character> charSet = new LinkedHashSet<>();
        
        for (char c : str.toCharArray()) {
            charSet.add(c); // Add characters to the set (duplicates will be ignored)
        }

        StringBuilder result = new StringBuilder();
        for (char c : charSet) {
            result.append(c); // Build the result string
        }

        return result.toString();
    }
}