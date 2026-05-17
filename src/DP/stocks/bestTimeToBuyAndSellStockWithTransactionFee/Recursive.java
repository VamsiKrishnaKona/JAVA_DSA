package DP.stocks.bestTimeToBuyAndSellStockWithTransactionFee;

public class Recursive
{
    public static void main(String[] args) {
        int[] prices = new int[] {1,3,2,8,4,9};
        int fee = 2;

        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee)
    {
        int n = prices.length;
        return solve(0, 1, prices, fee);
    }

    private static int solve(int ind, int buy, int[] prices, int fee)
    {
        if(ind == prices.length) return 0;

        if(buy == 1)
        {
            return Math.max(
                    -prices[ind] + solve(ind + 1, 0, prices, fee) - fee,
                    solve(ind + 1, 1, prices, fee));
        }
        return Math.max(
                prices[ind] + solve(ind + 1, 1, prices, fee),
                solve(ind + 1, 0, prices, fee));
    }
}
