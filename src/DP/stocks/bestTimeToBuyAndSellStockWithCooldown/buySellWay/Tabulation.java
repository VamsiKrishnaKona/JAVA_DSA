package DP.stocks.bestTimeToBuyAndSellStockWithCooldown.buySellWay;

public class Tabulation
{
    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 0, 2};

        int profit = buyAndSell(prices);
        System.out.println(profit);
    }

    private static  int buyAndSell(int[] prices)
    {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for(int ind = n - 1 ; ind >= 0 ; ind--)
        {
            for(int buy = 0 ; buy <= 1 ; buy++)
            {
                if(buy == 1)
                {
                    dp[ind][buy] = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);
                }
                else {
                    dp[ind][buy] = Math.max(prices[ind] + dp[ind + 2][1], dp[ind + 1][0]);

                }
            }
        }
        return dp[0][1];
    }
}
