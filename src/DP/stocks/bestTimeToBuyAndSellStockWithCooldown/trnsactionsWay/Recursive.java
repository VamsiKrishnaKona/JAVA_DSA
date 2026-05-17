package DP.stocks.bestTimeToBuyAndSellStockWithCooldown.trnsactionsWay;

public class Recursive
{
    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 0, 2};

        int profit = maxProfit(prices);
        System.out.println(profit);
    }

    private static int maxProfit(int[] prices)
    {
        return solve(0, 0, prices);
    }

    private static int solve(int ind, int transaction, int[] prices)
    {
        if(ind >= prices.length) return 0;

        if(transaction % 2 == 0)
        {
            return Math.max(
                    -prices[ind] + solve(ind + 1, transaction + 1, prices),
                    solve(ind + 1, transaction, prices)
            );
        }

        return Math.max(
                prices[ind] + solve(ind + 2, transaction + 1, prices),
                solve(ind + 1, transaction, prices)
        );
    }
}
