public class Laptop {
    public String brand;
    public int ram; // in GB
    public double price;

    // Constructor to initialize values
    public Laptop(String brand, int ram, double price) {
    this.brand = brand;
    this.ram = ram;
    this.price = price;
    }

    // Method to display laptop details
    public void displayDetails() {
    System.out.println("Brand: " + brand);
    System.out.println("RAM: " + ram + "GB");
    System.out.printf("Price: $%.2f%n", price);
    System.out.println(); // For spacing between entries
    }

    public static void main(String[] args) {
    // Create laptop objects
    Laptop laptop1 = new Laptop("Dell", 16, 899.99);
    Laptop laptop2 = new Laptop("Apple", 8, 1299.99);
    Laptop laptop3 = new Laptop("HP", 12, 699.50);

    // Display their details
    laptop1.displayDetails();
    laptop2.displayDetails();
    laptop3.displayDetails();
    }
}