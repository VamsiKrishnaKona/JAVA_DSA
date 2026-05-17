package DP.stocks.bestTimeToBuyAndSellStockWithTransactionFee;

public class Optimal {
    public static void main(String[] args) {
        int[] prices = new int[] {1,3,2,8,4,9};
        int fee = 2;

        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee)
    {
        int n = prices.length;
        int[] prev = new int[2];

        for (int ind = n - 1; ind >= 0; ind--) {
            int[] curr = new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    curr[buy] = Math.max(-prices[ind] + prev[0] - fee, prev[1]);
                } else {
                    curr[buy] = Math.max(prices[ind] + prev[1], prev[0]);
                }
            }
            prev = curr;
        }
        return prev[1];
    }
}
