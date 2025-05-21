// Define interface A
interface A {
    void display();
}

// Define interface B
interface B {
    void display();
}

// Implement the Demo class that implements both interfaces
class Demo implements A, B {
    @Override
    public void display() {
        System.out.println("Display method from Demo class.");
    }
}

// Main class to test the implementation
public class interfaces_02 {
    public static void main(String[] args) {
        Demo demo = new Demo(); // Create an instance of Demo
        demo.display(); // Call the display method
    }
}
