public class code {
    public static void main(String[] args) {
        String str = "Rishi";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
        for (int j = str.length() - 1; j >= 0; j--) {
            System.out.println(str.charAt(j));
        }
    }
}