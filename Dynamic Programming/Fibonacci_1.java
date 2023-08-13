// * Top-down approach

public class Fibonacci_1{

    public static int fib(int n){
        int a=0, b=1, c=0;

        if(n==0) return a;

        for(int i=2; i<=n; i++){
            c = a+b;
            a = b;
            b = c;
        }

        return c;
    }
    public static void main(String[] args) {
        int n = 7;
        System.out.println("Fibonacci of "+n+" is "+fib(n)+".");
    }
}