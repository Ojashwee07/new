// Define the Shape interface
interface Shape {
    double area(); // Method to calculate area
}

// Implement the Circle class that implements Shape
class Circle implements Shape {
    private final double radius = 5; // Radius of the circle

    @Override
    public double area() {
        return Math.PI * radius * radius; // Calculate area using the formula πr²
    }

    public double getRadius() {
        return radius;
    }
}

// Main class to test the implementation
public class ShapeInterface {
    public static void main(String[] args) {
        Circle circle = new Circle(); // Create an instance of Circle
        System.out.println("Area of the circle: " + circle.area()); // Print the area
    }
}
