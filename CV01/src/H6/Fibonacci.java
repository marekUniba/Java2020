package H6;

public class Fibonacci {

    public static long fib(int n) {

        // toto doprogramuj
        long a = 1;
        long b = 1;
        long c = 0;

        for(int i=0; i < n-1; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        for(int i =1; i<30;i++) {
            System.out.println(fib(i));
        }
    }
}
