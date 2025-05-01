public class Rectangle {
    public  double length;
    public  double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double calculateArea() {
        return length * breadth;
    }

    public double calculatePerimeter() {
        return 2 * (length + breadth);
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(5, 10);
        Rectangle rectangle2 = new Rectangle(3.5, 2.5);
        Rectangle rectangle3 = new Rectangle(10, 20);

        System.out.println("Rectangle 1 - Area: " + rectangle1.calculateArea() + ", Perimeter: " + rectangle1.calculatePerimeter());
        System.out.println("Rectangle 2 - Area: " + rectangle2.calculateArea() + ", Perimeter: " + rectangle2.calculatePerimeter());
        System.out.println("Rectangle 3 - Area: " + rectangle3.calculateArea() + ", Perimeter: " + rectangle3.calculatePerimeter());
    }
}
