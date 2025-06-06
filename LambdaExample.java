// Define a functional interface
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class LambdaExample {
    public static void main(String[] args) {
        // Using a lambda expression to implement the sayHello method
        Greeting greeting = (name) -> System.out.println("Hello, " + name + "!");

        // Call the method
        greeting.sayHello("Rishi");
        greeting.sayHello("Hii");
    }
}