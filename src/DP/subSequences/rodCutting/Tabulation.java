package DP.subSequences.rodCutting;

import java.util.Arrays;

public class Tabulation
{
    public static void main(String[] args) {

        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};

        int maxPrice = findMaxPrice(prices);

        System.out.println(maxPrice);
    }

    public static int findMaxPrice(int[] prices)
    {
        int n  = prices.length;
        int[][] dp = new int[n][n + 1];

        for(int len = 0 ; len <= n ; len++) dp[0][len] = len * prices[0];

        for(int ind = 1 ; ind < n ; ind++)
        {
            for(int len = 0 ; len <= n ; len++)
            {
                int notTake =  dp[ind - 1][len]; //solve(ind - 1, len, prices, dp);
                int take = (int) -1e7;

                if(len > ind) take = prices[ind] + dp[ind][len - ind - 1]; //solve(ind, len - ind - 1, prices, dp);

                dp[ind][len] = Math.max(notTake, take);
            }
        }

        return dp[n - 1][n];
    }
}
