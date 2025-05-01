class Laptop1 {
        String brand;
    int ram; 
       int storage; 
    public Laptop1(String brand, int ram, int storage) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
    }
    public String getDetails() {
        return "Brand: " + brand + ", RAM: " + ram + "GB, Storage: " + storage + "GB";
    }
    public static void main(String[] args) {
        Laptop1 laptop1 = new Laptop1("Dell", 16, 512);
        Laptop1 laptop2 = new Laptop1("HP", 8, 256);
        Laptop1 laptop3 = new Laptop1("Apple", 16, 1024);
        System.out.println("Laptop 1 Details: " + laptop1.getDetails());
        System.out.println("Laptop 2 Details: " + laptop2.getDetails());
        System.out.println("Laptop 3 Details: " + laptop3.getDetails());
    }
}