package DP.stocks.bestTimeToBuyAndSellStock3.dpx2x3;

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
        int[][] dp = new int[2][3];

        for(int i = n - 1 ; i >= 0 ; i--)
        {
            int[][] curr = new int[2][3];
            for(int buy = 0 ; buy <= 1 ; buy++)
            {
                for(int cap = 1 ; cap <= 2 ; cap++)
                {
                    int profit = 0;
                    if(buy == 1)
                    {
                        curr[buy][cap] = profit + Math.max(-prices[i] + dp[0][cap], dp[1][cap]);
                    }
                    else {
                        curr[buy][cap] = profit + Math.max(prices[i] + dp[1][cap - 1], dp[0][cap]);
                    }
                }
            }
            dp = curr;
        }
        return dp[1][2];
    }
}
