package DP.stocks.bestTimeToBuyAndSellStock2;

public class Optimal
{
    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        long profit = buyAndSell(prices);
        System.out.println(profit);
    }

    private static long buyAndSell(int[] prices)
    {
        int n = prices.length;
        long[] dp = new long[2];

        for(int i = n - 1 ; i >= 0 ; i--)
        {
            long[] curr = new long[2];
            for(int buy = 0 ; buy <= 1 ; buy++)
            {
                long profit = 0;
                if(buy == 1)
                {
                    long bought = profit -  prices[i] + dp[0]; //solve(i + 1, 0, prices, dp);
                    long notBought =  dp[1]; //solve(i + 1, 1, prices, dp);

                    profit += Math.max(bought, notBought);
                }
                else
                {
                    long sold = prices[i] + dp[1];  //solve(i + 1, 1, prices, dp);
                    long notSold =  dp[0]; //solve(i + 1, 0, prices, dp);

                    profit += Math.max(sold, notSold);
                }

                curr[buy] = profit;
            }
            dp = curr;
        }

        return dp[1];
    }
}
