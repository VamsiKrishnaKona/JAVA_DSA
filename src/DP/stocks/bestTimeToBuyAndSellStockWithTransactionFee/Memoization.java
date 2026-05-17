package DP.stocks.bestTimeToBuyAndSellStockWithTransactionFee;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args) {
        int[] prices = new int[] {1,3,2,8,4,9};
        int fee = 2;

        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee)
    {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(0, 1, prices, fee, dp);
    }

    private static int solve(int ind, int buy, int[] prices, int fee, int[][] dp)
    {
        if(ind == prices.length) return 0;

        if(dp[ind][buy] != -1) return dp[ind][buy];

        if(buy == 1)
        {
            return dp[ind][buy] = Math.max(
                    -prices[ind] + solve(ind + 1, 0, prices, fee, dp) - fee,
                    solve(ind + 1, 1, prices, fee, dp));
        }
        return dp[ind][buy] = Math.max(
                prices[ind] + solve(ind + 1, 1, prices, fee, dp),
                solve(ind + 1, 0, prices, fee, dp));
    }
}
