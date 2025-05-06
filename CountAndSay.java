public class CountAndSay {
    public static void main(String[] args) {
        int n = 5; // Example input
        String result = countAndSay(n);
        System.out.println("The " + n + "th term in the Count and Say sequence is: " + result);
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1"; // Base case
        }

        // Get the previous term
        String previousTerm = countAndSay(n - 1);
        StringBuilder currentTerm = new StringBuilder();

        int count = 1; // Initialize count
        char currentChar = previousTerm.charAt(0); // Start with the first character

        // Iterate through the previous term
        for (int i = 1; i < previousTerm.length(); i++) {
            if (previousTerm.charAt(i) == currentChar) {
                count++; // Increment count if the same character is found
            } else {
                // Append the count and the character to the current term
                currentTerm.append(count).append(currentChar);
                currentChar = previousTerm.charAt(i); // Update current character
                count = 1; // Reset count
            }
        }

        // Append the last counted character
        currentTerm.append(count).append(currentChar);

        return currentTerm.toString(); // Return the current term
    }
}