package DP.stocks.bestTimeToBuyAndSellStock3.dpx4;

public class Optimal
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
        int[] dp = new int[4 + 1];

        for(int i = n - 1 ; i >= 0 ; i--)
        {
            int[] curr = new int[4 + 1];
            for(int transaction = 0 ; transaction < 4 ; transaction++)
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
