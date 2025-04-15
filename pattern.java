public class pattern {
    public static void main(String[] args) {
        int rows = 5; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = rows - i; k > 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}