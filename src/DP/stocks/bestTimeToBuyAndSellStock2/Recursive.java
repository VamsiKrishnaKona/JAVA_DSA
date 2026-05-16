package DP.stocks.bestTimeToBuyAndSellStock2;

public class Recursive
{
    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        int profit = buyAndSell(prices);
        System.out.println(profit);
    }

    private static  int buyAndSell(int[] prices)
    {
        int n = prices.length;

        return solve(0, true, prices);
    }

    private static int solve(int i, boolean buy, int[] prices)
    {
        if(i == prices.length) return 0;
        int profit = 0;
        if(buy)
        {
            int bought = profit -  prices[i] + solve(i + 1, false, prices);
            int notBought = solve(i + 1, true, prices);

            profit += Math.max(bought, notBought);
        }
        else
        {
            int sold = prices[i] + solve(i + 1, true, prices);
            int notSold = solve(i + 1, false, prices);

            profit += Math.max(sold, notSold);
        }

        return profit;
    }
}
