public class PalindromeCheck {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal, Panama!";
        boolean isPalindrome = isPalindrome(input);
        System.out.println("Is the string a palindrome? " + isPalindrome);
    }

    public static boolean isPalindrome(String str) {
        // Normalize the string
        String normalizedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindromeHelper(normalizedStr, 0, normalizedStr.length() - 1);
    }

    private static boolean isPalindromeHelper(String str, int left, int right) {
        if (left >= right) {
            return true; // Base case: all characters checked
        }
        if (str.charAt(left) != str.charAt(right)) {
            return false; // Not a palindrome
        }
        return isPalindromeHelper(str, left + 1, right - 1);
    }
}