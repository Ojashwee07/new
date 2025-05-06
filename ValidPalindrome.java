public class ValidPalindrome {

    // Helper method to check if s[left..right] is palindrome
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Main method to check if valid palindrome possible by removing at most one character
    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try skipping left character or right character
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "abca";
        String s2 = "raceacar";
        String s3 = "deeee";

        System.out.println("Input: " + s1 + " -> " + validPalindrome(s1)); // true
        System.out.println("Input: " + s2 + " -> " + validPalindrome(s2)); // true
        System.out.println("Input: " + s3 + " -> " + validPalindrome(s3)); // true
    }
}
