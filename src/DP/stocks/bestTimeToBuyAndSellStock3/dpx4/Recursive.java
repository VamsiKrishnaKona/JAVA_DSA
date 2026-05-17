package DP.stocks.bestTimeToBuyAndSellStock3.dpx4;

public class Recursive
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

        return solve(0, 0, prices);
    }

    private static int solve(int i, int transaction, int[] prices)
    {
        if(i == prices.length || transaction == 2 * 2) return 0;

        if(transaction % 2 == 0)
        {
            return Math.max(-prices[i] + solve(i + 1, transaction + 1, prices), solve(i + 1, transaction, prices));
        }

        return Math.max(prices[i] + solve(i + 1, transaction + 1, prices), solve(i + 1, transaction, prices));
    }
}
