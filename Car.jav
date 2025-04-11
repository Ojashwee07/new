class Car {
    String color;

      public Car(String color) {
        this.color = color;
    }

       public String getColor() {
        return color;
    }

    public static void main(String[] args) {
               Car myCar = new Car("Red");
        System.out.println(myCar.getColor());
    }
}