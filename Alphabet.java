public class Alphabet {
    public static void main(String[] args) {
        int rows = 3; 

        for (int i = 1; i <= rows; i++) {
                        for (char j = 'A'; j < 'A' + i; j++) {
               
                if (i == 2 && j == 'B') {
                    System.out.print(Character.toUpperCase(j)); 
                } else if (j == 'A') {
                    System.out.print(j);
                    if (i == 3 && j == 'C') {
                        System.out.print(Character.toUpperCase(j)); 
                    } else if (j == 'B') {
                        System.out.print(j); 
                } else {
                    System.out.print(Character.toLowerCase(j));
                }
            }
            System.out.println();
        }
    }
}
}