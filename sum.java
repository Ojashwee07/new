public class sum {
    public static void main(String[] args){
        int a= 121; 
        int original = a;
        int res =0;
    while (a>0){
        int digit =a %10;
        res = res * 10+ digit;
        a=a / 10;

    }
    if (a==res) 
    {
System.out.println(".Yes it is a palindrome");
}
else {
System.out.println(" NO it's a not a palindrome");
    } 
}
}