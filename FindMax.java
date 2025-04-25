class FindMax {
    static int sum(int a, int b) {
        return a + b;
    }

    static int maxDigit(int number) {
        int maxDigit = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit > maxDigit) {
                maxDigit = digit; 
            }
            number /= 10; 
        }
        return maxDigit;
    }

    public static void main(String[] args) {
        int output = sum(202, 7);
        System.out.println("Sum: " + output);
        
        int maxDigit = maxDigit(output);
        System.out.println("Max digit of the sum: " + maxDigit);
    }
}