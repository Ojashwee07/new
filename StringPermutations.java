
public class StringPermutations {
    public static void main(String[] args) {
        String input = "abc"; // Example input
        System.out.println("All permutations of the string \"" + input + "\":");
        printPermutations(input, "");
    }

    public static void printPermutations(String str, String prefix) {
        // Base case: if the string is empty, print the prefix
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            // Iterate through the string
            for (int i = 0; i < str.length(); i++) {
                // Choose the current character
                char currentChar = str.charAt(i);
                // Form the remaining string without the current character
                String remaining = str.substring(0, i) + str.substring(i + 1);
                // Recur with the remaining string and the updated prefix
                printPermutations(remaining, prefix + currentChar);
            }
        }
    }
}