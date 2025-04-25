public class SumExample2 {
    static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10; 
            number /= 10;       
        }

        return sum;
    }
    static void sum(int a, int b) {
        int result = a + b;
        System.out.println("The sum of " + a + " and " + b + " is: " + result);
    }

    public static void main(String[] args) {
        int digitSum = sumOfDigits(123);
        System.out.println("The sum of the digits of 123 is: " + digitSum);
        sum(5, 10); 
    }
}