// Define the Animal interface
interface Animal {
    void makeSound();
}

// Implement the Dog class that implements the Animal interface
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

// Main class to test the implementation
public class myDog {
    public static void main(String[] args) {
        Animal myDog = new Dog(); // Use interface reference to create a Dog object
        myDog.makeSound(); // Call the makeSound method
    }
}
