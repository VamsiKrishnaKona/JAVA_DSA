package DP.stocks.bestTimeToBuyAndSellStock3.dpx4;

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
        int[][] dp = new int[n][4];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 0, prices, dp);
    }

    private static int solve(int i, int transaction, int[] prices, int[][] dp)
    {
        if(i == prices.length || transaction == 2 * 2) return 0;
        if(dp[i][transaction] != -1) return dp[i][transaction];

        if(transaction % 2 == 0)
        {
            return dp[i][transaction] = Math.max(
                    -prices[i] + solve(i + 1, transaction + 1, prices, dp),
                    solve(i + 1, transaction, prices, dp)
            );
        }

        return dp[i][transaction] = Math.max(
                prices[i] + solve(i + 1, transaction + 1, prices, dp),
                solve(i + 1, transaction, prices, dp)
        );
    }
}
