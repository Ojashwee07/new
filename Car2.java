class Car2 {
    String color;

      public Car2(String color) {
        this.color = color;
    }

       public String getColor() {
        return color;
    }

    public static void main(String[] args) {
               Car2 myCar = new Car2("Red");
        System.out.println(myCar.getColor());
    }
}