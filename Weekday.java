import java.util.Scanner;
public class Weekday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number (1-7) to get the corresponding weekday: ");
        int day = scanner.nextInt();
        
        String weekday;
        
        switch (day) {
            case 1:
                weekday = "Monday";
                break;
            case 2:
                weekday = "Tuesday";
                break;
            case 3:
                weekday = "Wednesday";
                break;
            case 4:
                weekday = "Thursday";
                break;
            case 5:
                weekday = "Friday";
                break;
            case 6:
                weekday = "Saturday";
                break;
            case 7:
                weekday = "Sunday";
                break;
            default:
                weekday = "Invalid input Please enter a number between 1 and 7.";
        }
        System.out.println("The day of the week is:" + weekday );
        
        scanner.close();
    }
}