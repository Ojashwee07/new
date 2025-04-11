public class Prime {
    public static void main(String[] args) {
        int num = 7; 
        boolean isPrime = true;
        if (num < 2) {
            isPrime = false;
        } else {
               for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        System.out.println(isPrime ? "Prime" : "Not Prime");
    }
}