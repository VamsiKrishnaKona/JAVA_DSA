package DP.stocks.bestTimeToBuyAndSellStock3.dpx2x3;

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

        return solve(0, 1, 2, prices);
    }

    private static int solve(int i, int buy, int cap, int[] prices)
    {
        if(i == prices.length || cap == 0) return 0;

        if(buy == 1)
        {
            return Math.max(-prices[i] + solve(i + 1, 0, cap, prices), solve(i + 1, 1, cap, prices));
        }

        return Math.max(prices[i] + solve(i + 1, 1, cap - 1, prices), solve(i + 1, 0, cap, prices));
    }
}
