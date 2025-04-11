class Mobile {
    String brand;
    String model;
    public Mobile(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    public String getDetails() {
        return "Brand: " + brand + ", Model: " + model;
    }

    public static void main(String[] args) {
        Mobile mobile1 = new Mobile("Apple", "iPhone 16");
        Mobile mobile2 = new Mobile("Samsung", "Galaxy S25 ulrta");
        System.out.println("Mobile 1 Details: " + mobile1.getDetails());
        System.out.println("Mobile 2 Details: " + mobile2.getDetails());
    }
}