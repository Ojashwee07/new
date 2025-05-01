public class Book {
    public String title;
    public String author;
    public double price;

    // Constructor to initialize book details
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Applies a 10% discount to the price and displays the new price
    public void applyDiscount() {
        price *= 0.9; // Reduces price by 10%
        System.out.printf("Applied 10%% discount. New price for \"%s\": $%.2f%n", title, price);
    }

    // Displays all book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.printf("Price: $%.2f%n", price);
        System.out.println(); // Adds a blank line for separation
    }

    public static void main(String[] args) {
        // Create Book objects
        Book book1 = new Book("The Alchemist", "Paulo Coelho", 25.99);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 19.50);

        // Display initial details
        book1.displayDetails();
        book2.displayDetails();

        // Apply discounts and show updated prices
        book1.applyDiscount();
        book2.applyDiscount();

        // Display details again to confirm price changes
        book1.displayDetails();
        book2.displayDetails();
    }
}