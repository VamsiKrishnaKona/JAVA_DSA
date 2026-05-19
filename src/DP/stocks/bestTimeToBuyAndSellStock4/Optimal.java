package DP.stocks.bestTimeToBuyAndSellStock4;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;

        int profit = maxProfit(k, prices);
        System.out.println(profit);
    }

    public static int maxProfit(int k, int[] prices)
    {
        int n = prices.length;
        int[] dp = new int[(k * 2) + 1];

        for(int i = n - 1 ; i >= 0 ; i--)
        {
            int[] curr = new int[(k * 2) + 1];
            for(int transaction = 0 ; transaction < k * 2 ; transaction++)
            {
                if(transaction % 2 == 0)
                {
                    curr[transaction] = Math.max(-prices[i] +  dp[transaction + 1] , dp[transaction]);
                }
                else
                {
                    curr[transaction] = Math.max(prices[i] + dp[transaction + 1], dp[transaction]);
                }
            }
            dp = curr;
        }

        return dp[0];
    }
}
