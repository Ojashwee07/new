public class SubstringSearch {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll"; // Example input
        int result = strStr(haystack, needle);
        System.out.println("Index of the first occurrence: " + result);
    }

    public static int strStr(String haystack, String needle) {
        // If needle is an empty string, return 0
        if (needle.isEmpty()) {
            return 0;
        }

        // Get the lengths of both strings
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        // If the needle is longer than the haystack, it cannot be found
        if (needleLength > haystackLength) {
            return -1;
        }

        // Iterate through the haystack
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            // Check if the substring matches
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i; // Return the starting index
            }
        }

        return -1; // Return -1 if the needle is not found
    }
}