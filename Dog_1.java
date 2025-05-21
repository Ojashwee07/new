class Dog_1 {
    String name;
    public Dog_1(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog("Buddy");
        Dog dog2 = new Dog("Max");
        Dog dog3 = new Dog("Bella");
        System.out.println("Dog 1's name: " + dog1.getName());
        System.out.println("Dog 2's name: " + dog2.getName());
        System.out.println("Dog 3's name: " + dog3.getName());
    }
}