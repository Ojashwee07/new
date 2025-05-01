public class Calculator {
    
    // Adds two numbers
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    // Subtracts the second number from the first
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Multiplies two numbers
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // Divides the first number by the second (handles division by zero)
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return num1 / num2;
    }

    public static void main(String[] args) {
        Calculator myCalculator = new Calculator();

        // Example calculations
        System.out.println("Addition: 12.5 + 3.2 = " + myCalculator.add(12.5, 3.2));
        System.out.println("Subtraction: 15.8 - 7.3 = " + myCalculator.subtract(15.8, 7.3));
        System.out.println("Multiplication: 4.5 * 6 = " + myCalculator.multiply(4.5, 6));
        System.out.println("Division: 20 / 4 = " + myCalculator.divide(20, 4));

        // Handle division by zero scenario
        try {
            System.out.println("Division by zero: 10 / 0 = " + myCalculator.divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}