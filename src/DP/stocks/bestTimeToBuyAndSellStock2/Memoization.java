package DP.stocks.bestTimeToBuyAndSellStock2;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

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

    private static int solve(int i, int buy, int[] prices, int[][] dp)
    {
        if(i == prices.length) return 0;

        if(dp[i][buy] != -1) return  dp[i][buy];
        int profit = 0;
        if(buy == 1)
        {
            int bought = profit -  prices[i] + solve(i + 1, 0, prices, dp);
            int notBought = solve(i + 1, 1, prices, dp);

            profit += Math.max(bought, notBought);
        }
        else
        {
            int sold = prices[i] + solve(i + 1, 1, prices, dp);
            int notSold = solve(i + 1, 0, prices, dp);

            profit += Math.max(sold, notSold);
        }

        return dp[i][buy] = profit;
    }
}
