// * Bottom-up approach

public class Fibonacci_2 {

    public static int fHelper(int n, int[] f){

        if(n==0 || n==1){
            return n;
        }
        if(f[n] != -1){
            return f[n];
        }
        
        int x = fHelper(n-1, f);
        int y = fHelper(n-2, f);

        f[n] = x+y;

        return f[n];
    }

    public static int fib(int n){
        int f[] = new int[n+1];

        // * initialize to -1
        for (int i=0; i<=n; i++){
            f[i] = -1;
        }

        return fHelper(n, f);
    }   
    public static void main(String[] args) {
        int n = 7;
        System.out.println("Fibonacci of "+n+" is "+fib(n)+".");
    }
}
