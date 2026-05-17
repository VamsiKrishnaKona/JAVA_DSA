package DP.stocks.bestTimeToBuyAndSellStock3.dpx2x3;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args)
    {
        int[] prices = {3,3,5,0,0,3,1,4};

        int profit = buyAndSell(prices);
        System.out.println(profit);
    }

    private static  int buyAndSell(int[] prices)
    {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int i = 0 ; i < n ; i++)
        {
            for(int[] row : dp[i]) Arrays.fill(row, -1);
        }
        return solve(0, 1, 2, prices, dp);
    }

    private static int solve(int i, int buy, int cap, int[] prices, int[][][] dp)
    {
        if(i == prices.length || cap == 0) return 0;

        if(dp[i][buy][cap] != -1) return dp[i][buy][cap];

        if(buy == 1)
        {
            return dp[i][buy][cap] = Math.max(-prices[i] + solve(i + 1, 0, cap, prices, dp), solve(i + 1, 1, cap, prices, dp));
        }

        return dp[i][buy][cap] = Math.max(prices[i] + solve(i + 1, 1, cap - 1, prices, dp), solve(i + 1, 0, cap, prices, dp));
    }
}
