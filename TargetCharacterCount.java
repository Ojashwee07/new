import java.util.Scanner;

public class TargetCharacterCount {
    public static void main(String[] args) {
        String str = "racecar";
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a character to count in \"" + str + "\": ");
        char target = scanner.next().charAt(0); 
        
        int count = countTargetCharacter(str, target); 
        
        System.out.println("The character '" + target + "' appears " + count + " times in \"" + str + "\".");
        
        scanner.close();
    }

    public static int countTargetCharacter(String str, char target) {
        int count = 0; 
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) { 
                count++; 
            }
        }
        
        return count; 
    }
}