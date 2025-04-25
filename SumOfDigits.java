public class SumOfDigits {
    static void sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10; 
            number /= 10;      
        }
        System.out.println("The sum of the digits is: " + sum);
    }
    public static void main(String[] args) {
        sumOfDigits(123);
    }
}