package DP.oneD.fibonacci;

public class Optimal
{
    public static void main(String[] args)
    {
        int n = 5;

        System.out.println(fib(n));
    }

    private static int fib(int n)
    {
        if(n <= 1)
        {
            return n;
        }

        int prev2 = 0;
        int prev = 1;

        for(int i = 2 ; i <= n ; i++)
        {
            int curr =  prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
