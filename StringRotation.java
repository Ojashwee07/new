public class StringRotation {

    public static boolean isRotation(String s1, String s2) {
        // Check if lengths are equal
        if (s1.length() != s2.length()) {
            return false;
        }

        // Concatenate s2 with itself
        String concatenated = s2 + s2;

        // Check if s1 is a substring of the concatenated string
        return concatenated.contains(s1);
    }

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        boolean result = isRotation(s1, s2);
        System.out.println(s1 + " is a rotation of " + s2 + ": " + result); // Output: true

        // Additional test cases
        System.out.println(isRotation("abcde", "cdeab")); // Output: true
        System.out.println(isRotation("abcde", "abced")); // Output: false
        System.out.println(isRotation("hello", "lohel")); // Output: true
        System.out.println(isRotation("hello", "world")); // Output: false
    }
}