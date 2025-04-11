class AreaOfCircle {
    double radius;
    public AreaOfCircle(double radius) {
        this.radius = radius;
    }
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {
        AreaOfCircle circle1 = new AreaOfCircle(5.0); 
        AreaOfCircle circle2 = new AreaOfCircle(7.5); 
        System.out.printf("Circumference of Circle 1: %.2f%n", circle1.calculateCircumference());
        System.out.printf("Circumference of Circle 2: %.2f%n", circle2.calculateCircumference());
    }
}