package DP.oneD.fibonacci;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args)
    {
        int n = 3;

        fib(n);
    }

    private static void fib(int n)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(fibo(n, dp));
    }

    private static int fibo(int n, int[] dp)
    {
        if(n <= 1) return n;
        if(dp[n] !=  -1) return dp[n];

        return dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
    }
}
