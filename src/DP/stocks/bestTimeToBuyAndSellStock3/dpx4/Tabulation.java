package DP.stocks.bestTimeToBuyAndSellStock3.dpx4;

public class Tabulation
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
        int[][] dp = new int[n + 1][4 + 1];

        for(int i = n - 1 ; i >= 0 ; i--)
        {
            for(int transaction = 0 ; transaction < 4 ; transaction++)
            {
                if(transaction % 2 == 0)
                {
                    dp[i][transaction] = Math.max(-prices[i] +  dp[i + 1][transaction + 1] , dp[i + 1][transaction]);
                }
                else
                {
                    dp[i][transaction] = Math.max(prices[i] + dp[i + 1][transaction + 1], dp[i + 1][transaction]);
                }
            }
        }

        return dp[0][0];
    }
}
