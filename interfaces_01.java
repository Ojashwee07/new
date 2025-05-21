// Define the Walkable interface
interface Walkable {
    void walk();
}

// Define the Runnable interface
interface Runnable {
    void run();
}

// Implement the Human class that implements both interfaces
class Human implements Walkable, Runnable {
    @Override
    public void walk() {
        System.out.println("The human is walking.");
    }

    @Override
    public void run() {
        System.out.println("The human is running.");
    }
}

// Main class to test the implementation
public class interfaces_01 {
    public static void main(String[] args) {
        Human human = new Human(); // Create an instance of Human
        human.walk(); // Call the walk method
        human.run();  // Call the run method
    }
}
