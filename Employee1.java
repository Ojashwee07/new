class Employee1 {
    public static String company_name;
    String name;
    int id;
    double salary;
    public Employee1(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
   public String getDetails() {
        return "Name: " + name + ", ID: " + id + ", Salary: " + salary;
    }

    public static void main(String[] args) {
        Employee1 employee1 = new Employee1("Ojashwee", 101, 50000);
        Employee1 employee2 = new Employee1("Rishi", 102, 60000);
        Employee1 employee3 = new Employee1("Shalvi", 103, 55000);
        System.out.println("Employee 1 Details: " + employee1.getDetails());
        System.out.println("Employee 2 Details: " + employee2.getDetails());
        System.out.println("Employee 3 Details: " + employee3.getDetails());
    }
}