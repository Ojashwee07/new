class Employee {
    public static String company_name;
    String name;
    int id;
    double salary;
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
   public String getDetails() {
        return "Name: " + name + ", ID: " + id + ", Salary: " + salary;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Ojashwee", 101, 50000);
        Employee employee2 = new Employee("Rishi", 102, 60000);
        Employee employee3 = new Employee("Shalvi", 103, 55000);
        System.out.println("Employee 1 Details: " + employee1.getDetails());
        System.out.println("Employee 2 Details: " + employee2.getDetails());
        System.out.println("Employee 3 Details: " + employee3.getDetails());
    }
}