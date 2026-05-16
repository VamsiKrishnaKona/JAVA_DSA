package DP.stocks.bestTimeToBuyAndSellStock2;

import java.util.Arrays;

public class Tabulation
{
    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        long profit = buyAndSell(prices);
        System.out.println(profit);
    }

    private static long buyAndSell(int[] prices)
    {
        int n = prices.length;
        long[][] dp = new long[n + 1][2];

        for(int i = n - 1 ; i >= 0 ; i--)
        {
            for(int buy = 0 ; buy <= 1 ; buy++)
            {
                long profit = 0;
                if(buy == 1)
                {
                    long bought = profit -  prices[i] + dp[i + 1][0]; //solve(i + 1, 0, prices, dp);
                    long notBought =  dp[i + 1][1]; //solve(i + 1, 1, prices, dp);

                    profit += Math.max(bought, notBought);
                }
                else
                {
                    long sold = prices[i] + dp[i + 1][1];  //solve(i + 1, 1, prices, dp);
                    long notSold =  dp[i + 1][0]; //solve(i + 1, 0, prices, dp);

                    profit += Math.max(sold, notSold);
                }

                dp[i][buy] = profit;
            }
        }

        return dp[0][1];
    }
}
