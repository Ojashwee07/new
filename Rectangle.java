class Rectangle {
    // Instance variables
    double length;
    double width;

    // Constructor to initialize length and width
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Method to calculate the area of the rectangle
    public double calculateArea() {
        return length * width;
    }

    public static void main(String[] args) {
        // Create an object of the Rectangle class and assign values to length and width
        Rectangle myRectangle = new Rectangle(5.0, 3.0);

        // Calculate and print the area of the rectangle
        double area = myRectangle.calculateArea();
        System.out.println("Area of the rectangle: " + area);
    }
}