import java.util.HashMap;
public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0; // Left pointer of the sliding window
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            // If the character is already in the map and its index is within the current window
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                // Move the start pointer to the right of the last occurrence
                start = charIndexMap.get(currentChar) + 1;
            }
            // Update the last index of the character
            charIndexMap.put(currentChar, end);
            // Calculate the length of the current substring
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String input = "abcabcbb";
        int result = lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + result); // Output: 3
        // Additional test cases
        System.out.println(lengthOfLongestSubstring("bbbbb")); // Output: 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // Output: 3
        System.out.println(lengthOfLongestSubstring("")); // Output: 0
        System.out.println(lengthOfLongestSubstring("a")); // Output: 1
    }
}