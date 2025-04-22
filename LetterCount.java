import java.util.HashMap;
public class LetterCount {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hiiii";
        HashMap<Character, Integer> countMap1 = countLetters(str1);
        HashMap<Character, Integer> countMap2 = countLetters(str2);
        System.out.println("Common letters and their counts:");
        for (char c : countMap1.keySet()) {
            if (countMap2.containsKey(c)) {
                System.out.println(c + ": " + Math.min(countMap1.get(c), countMap2.get(c)));
            }
        }
    }
    private static HashMap<Character, Integer> countLetters(String str) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        return countMap;
    }
}