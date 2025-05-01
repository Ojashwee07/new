public class Car {
    public String brand;
    public String model;
    public double price;

    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.printf("Price: $%.2f%n", price);
        System.out.println();// Adds a blank line for separation
    }

    public static void main(String[] args) {
        Car car1 = new Car("Bmw ", "m5", 25000.00);
        Car car2 = new Car("Honda", "Civic", 22000.50);
        Car car3 = new Car("Ford", "Mustang", 35000.75);

        car1.displayDetails();
        car2.displayDetails();
        car3.displayDetails();
    }
}