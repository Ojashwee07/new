
public class VowelCounter {
    public static void main(String[] args) {
        String str = "racecarjhdgahAEIOUaha";
        int vowelCount = countVowels(str);   
        System.out.println("The string \"" + str + "\" contains " + vowelCount + " vowels.");
    }
    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiou";
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (vowels.indexOf(currentChar) != -1) {
                count++;
            }
        }
        return count;
    }
    public static int countConsonants(String str) {
        int count = 0;
        String vowels = "aeiou";
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (Character.isLetter(currentChar) && vowels.indexOf(currentChar) == -1) {
                count++; 
            }
        }
        
        return count; 
    }
}