public class AlphabetPattern {
    public static void main(String[] args) {
        int rows = 3;
 for (int i = 1; i <= rows; i++) {
            for (char j = 'A'; j < 'A' + i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}