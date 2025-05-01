public class Employee {
    public String name;
    public String id;
    public double salary;

    // Constructor to initialize employee details
    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Applies a 5% salary increment
    public void applyIncrement() {
        salary *= 1.05; // Increases salary by 5%
    }

    // Displays employee details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.printf("Salary: $%.2f%n", salary);
        System.out.println(); // Adds a blank line for separation
    }

    public static void main(String[] args) {
        // Create Employee objects
        Employee emp1 = new Employee("Rishi Dayal", "E101", 50000.0);
        Employee emp2 = new Employee("Ojashwee", "E202", 75000.0);

        
        // Display initial details
        System.out.println("=== Before Salary Increment ===");
        emp1.displayDetails();
        emp2.displayDetails();

        // Apply 5% increment
        emp1.applyIncrement();
        emp2.applyIncrement();

        // Display updated details
        System.out.println("=== After 5% Salary Increment ===");
        emp1.displayDetails();
        emp2.displayDetails();
    }
}