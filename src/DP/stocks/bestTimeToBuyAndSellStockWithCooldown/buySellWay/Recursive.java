package DP.stocks.bestTimeToBuyAndSellStockWithCooldown.buySellWay;

public class Recursive
{
    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 0, 2};

        int profit = buyAndSell(prices);
        System.out.println(profit);
    }

    private static  int buyAndSell(int[] prices)
    {
        int n = prices.length;
        return solve(0, 1, prices);
    }

    private static int solve(int ind, int buy, int[] prices)
    {
        if(ind >= prices.length) return 0;
        if(buy == 1)
        {
            return Math.max(-prices[ind] + solve(ind + 1, 0, prices), solve(ind + 1, 1, prices));
        }
        return Math.max(prices[ind] + solve(ind + 2, 1, prices), solve(ind + 1, 0, prices));
    }
}
