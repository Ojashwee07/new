public class Circle {
    public double radius;

    // Constructor to initialize the radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate the area of the circle
    public double calculateArea() {
        return Math.PI * radius * radius; // Area = π * r^2
    }

    // Method to calculate the circumference of the circle
    public double calculateCircumference() {
        return 2 * Math.PI * radius; // Circumference = 2 * π * r
    }

    public static void main(String[] args) {
        // Create Circle objects with different radii
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(10.0);
        Circle circle3 = new Circle(15.0);

        // Display area and circumference for each circle
        System.out.printf("Circle 1 - Radius: %.2f, Area: %.2f, Circumference: %.2f%n", 
        circle1.radius, circle1.calculateArea(), circle1.calculateCircumference());
        System.out.printf("Circle 2 - Radius: %.2f, Area: %.2f, Circumference: %.2f%n",
        circle2.radius, circle2.calculateArea(), circle2.calculateCircumference());
        System.out.printf("Circle 3 - Radius: %.2f, Area: %.2f, Circumference: %.2f%n", 
        circle3.radius, circle3.calculateArea(), circle3.calculateCircumference());
    }
}