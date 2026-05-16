package DP.subSequences.rodCutting;

public class Recursive
{
    public static void main(String[] args) {

        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};

        int maxPrice = findMaxPrice(prices);

        System.out.println(maxPrice);
    }

    public static int findMaxPrice(int[] prices)
    {
        int n  = prices.length;
        return solve(n - 1, n, prices);
    }

    private static int solve(int ind, int len, int[] prices)
    {
        if(ind < 0 || len <= 0) return 0;

        if(ind == 0)
        {
            if(len > ind) return prices[0] * len;
            else return 0;
        }

        int notTake = solve(ind - 1, len, prices);
        int take = (int) -1e7;

        if(len > ind) take = prices[ind] + solve(ind, len - ind - 1, prices);

        return Math.max(notTake, take);
    }
}
