package DP.stocks.bestTimeToBuyAndSellStock3.dpx2x3;

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
        int[][][] dp = new int[n + 1][2][3];

        for(int i = n - 1 ; i >= 0 ; i--)
        {
            for(int buy = 0 ; buy <= 1 ; buy++)
            {
                for(int cap = 1 ; cap <= 2 ; cap++)
                {
                    int profit = 0;
                    if(buy == 1)
                    {
                        dp[i][buy][cap] = profit + Math.max(-prices[i] + dp[i + 1][0][cap], dp[i + 1][1][cap]);
                    }
                    else {
                        dp[i][buy][cap] = profit + Math.max(prices[i] + dp[i + 1][1][cap - 1], dp[i + 1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}
