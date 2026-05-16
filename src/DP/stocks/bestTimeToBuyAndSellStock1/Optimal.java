package DP.stocks.bestTimeToBuyAndSellStock1;

public class Optimal
{
    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        int profit = buyAndSell(prices);
        System.out.println(profit);
    }

    private static  int buyAndSell(int[] prices)
    {
        int n = prices.length;

        int bought = (int) 1e9;
        int profit = 0;

        for(int i = 0 ; i < n ; i++)
        {
            bought = Math.min(bought, prices[i]);

            if(bought < prices[i])
            {
                profit = Math.max(prices[i] - bought, profit);
            }
        }

        return profit;
    }
}
