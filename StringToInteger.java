public class StringToInteger {
    public static void main(String[] args) {
        String input = "1010101010110"; // Example input
        int result = myAtoi(input);
        System.out.println("Converted integer: " + result);
    }
    public static int myAtoi(String str) {
        // Remove leading whitespace
        str = str.trim();   
        // Check if the string is empty after trimming
        if (str.isEmpty()) {
            return 0;
        }
        int sign = 1; // 1 for positive, -1 for negative
        int index = 0; // Current index in the string
        long result = 0; // Use long to handle overflow
        // Check for optional sign
        if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        // Convert characters to integer
        while (index < str.length()) {
            char currentChar = str.charAt(index);
            // Break if the character is not a digit
            if (currentChar < '0' || currentChar > '9') {
                break;
            }
            // Update the result
            result = result * 10 + (currentChar - '0');
            // Check for overflow
            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            index++;
        }
        return (int) (result * sign); // Return the final result
    }
}