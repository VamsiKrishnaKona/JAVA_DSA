package DP.subSequences.rodCutting;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args) {

        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};

        int maxPrice = findMaxPrice(prices);

        System.out.println(maxPrice);
    }

    public static int findMaxPrice(int[] prices)
    {
        int n  = prices.length;
        int[][] dp = new int[n][n + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(n - 1, n, prices, dp);
    }

    private static int solve(int ind, int len, int[] prices, int[][] dp)
    {
        if(ind < 0 || len <= 0) return 0;

        if(ind == 0)
        {
            if(len > ind) return prices[0] * len;
            else return 0;
        }

        if(dp[ind][len] != -1) return dp[ind][len];

        int notTake = solve(ind - 1, len, prices, dp);
        int take = (int) -1e7;

        if(len > ind) take = prices[ind] + solve(ind, len - ind - 1, prices, dp);

        return dp[ind][len] = Math.max(notTake, take);
    }
}
