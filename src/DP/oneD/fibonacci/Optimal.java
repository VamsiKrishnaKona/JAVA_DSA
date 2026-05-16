package DP.oneD.fibonacci;

public class Optimal
{
    public static void main(String[] args)
    {
        int n = 3;

        System.out.println(fib(n));
    }

    private static int fib(int n)
    {
        int prev = 1;
        int prev2 = 0;

        for(int i = 2 ; i <= n ; i++)
        {
            int curr =  prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
