public class Lambda{
    public static void main(String[] args) {
        Runnable r = new Runnable (){
            public void run () {
                System.out.println("Hello");
            }
        };
    }
} 
