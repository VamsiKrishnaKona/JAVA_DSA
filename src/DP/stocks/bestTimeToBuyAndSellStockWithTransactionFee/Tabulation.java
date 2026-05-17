package DP.stocks.bestTimeToBuyAndSellStockWithTransactionFee;

import java.util.Arrays;

public class Tabulation
{
    public static void main(String[] args) {
        int[] prices = new int[] {1,3,2,8,4,9};
        int fee = 2;

        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee)
    {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    dp[ind][buy] = Math.max(-prices[ind] + dp[ind + 1][0] - fee, dp[ind + 1][1]);
                } else {
                    dp[ind][buy] = Math.max(prices[ind] + dp[ind + 1][1], dp[ind + 1][0]);
                }
            }
        }
        return dp[0][1];
    }
}
