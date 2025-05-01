public class Student {
    public  String name;
    public  int rollNumber;
    public double marks;

    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println(); // Add a blank line for separation
    }

    public static void main(String[] args) {
        Student student1 = new Student("Rishi", 101, 95.5);
        Student student2 = new Student("Shalvi", 102, 88.0);
        Student student3 = new Student("Sonam", 103, 76.3);

        student1.displayDetails();
        student2.displayDetails();
        student3.displayDetails();
    }
}