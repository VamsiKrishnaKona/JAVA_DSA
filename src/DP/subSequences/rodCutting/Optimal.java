package DP.subSequences.rodCutting;

public class Optimal
{
    public static void main(String[] args) {

        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};

        int maxPrice = findMaxPrice(prices);

        System.out.println(maxPrice);
    }

    public static int findMaxPrice(int[] prices)
    {
        int n  = prices.length;
        int[] prev = new int[n + 1];

        for(int len = 0 ; len <= n ; len++) prev[len] = len * prices[0];

        for(int ind = 1 ; ind < n ; ind++)
        {
            int[] curr = new int[n + 1];
            for(int len = 0 ; len <= n ; len++)
            {
                int notTake =  prev[len]; //solve(ind - 1, len, prices, dp);
                int take = (int) -1e7;

                if(len > ind) take = prices[ind] + curr[len - ind - 1]; //solve(ind, len - ind - 1, prices, dp);

                curr[len] = Math.max(notTake, take);
            }
            prev = curr;
        }

        return prev[n];
    }
}
