class Counter {
       static int count = 0;
    public Counter() {
        count++; 
    }
    public static int getCount() {
        return count;
    }
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        System.out.println("Number of Counter objects created: " + Counter.getCount());
    }
}