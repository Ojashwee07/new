public class RemoveDuplicateCharacters {
    public static void main(String[] args) {
        String input = "hello"; 
        String output = removeDuplicates(input); 
        System.out.println("Original string: " + input);
        System.out.println("String after removing duplicates: " + output);
    }
    private static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder(); 
        boolean[] seen = new boolean[256]; 
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i); 
            if (!seen[currentChar]) {
                seen[currentChar] = true; 
                result.append(currentChar); 
            }
        }
        return result.toString(); 
    }
}