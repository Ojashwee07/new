class Laptop {
        String brand;
    int ram; 
       int storage; 
    public Laptop(String brand, int ram, int storage) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
    }
    public String getDetails() {
        return "Brand: " + brand + ", RAM: " + ram + "GB, Storage: " + storage + "GB";
    }
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("Dell", 16, 512);
        Laptop laptop2 = new Laptop("HP", 8, 256);
        Laptop laptop3 = new Laptop("Apple", 16, 1024);
        System.out.println("Laptop 1 Details: " + laptop1.getDetails());
        System.out.println("Laptop 2 Details: " + laptop2.getDetails());
        System.out.println("Laptop 3 Details: " + laptop3.getDetails());
    }
}