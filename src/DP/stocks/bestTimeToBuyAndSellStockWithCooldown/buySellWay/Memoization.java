package DP.stocks.bestTimeToBuyAndSellStockWithCooldown.buySellWay;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 0, 2};

        int profit = buyAndSell(prices);
        System.out.println(profit);
    }

    private static  int buyAndSell(int[] prices)
    {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(0, 1, prices, dp);
    }

    private static int solve(int ind, int buy, int[] prices, int[][] dp)
    {
        if(ind >= prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];

        if(buy == 1)
        {
            return dp[ind][buy] = Math.max(
                    -prices[ind] + solve(ind + 1, 0, prices, dp),
                    solve(ind + 1, 1, prices, dp));
        }
        return dp[ind][buy] = Math.max(
                prices[ind] + solve(ind + 2, 1, prices, dp),
                solve(ind + 1, 0, prices, dp));
    }
}
