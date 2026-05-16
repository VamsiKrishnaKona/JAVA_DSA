package DP.oneD.fibonacci;

public class Recursive
{
    public static void main(String[] args)
    {
        int n = 3;

        int val = fib(n);

        System.out.println(val);
    }

    private static int fib(int n)
    {
        if(n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }
}
