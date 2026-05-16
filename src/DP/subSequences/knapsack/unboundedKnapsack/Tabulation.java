package DP.subSequences.knapsack.unboundedKnapsack;

import java.util.Arrays;

public class Tabulation
{
    public static void main(String[] args) {

        int[] weights = {2, 4, 6};
        int[] vals = {5, 11, 13};
        int weight = 10;

        int ans = findMaximumVals(weight, weights, vals);

        System.out.println(ans);
    }

    private static int findMaximumVals(int weight, int[] weights, int[] vals) {

        int n = vals.length;
        int[][] dp = new int[n][weight + 1];

        for(int wt = weights[0] ; wt <= weight ; wt++)
        {
            dp[0][wt] = (wt / weights[0]) * vals[0];
        }

        for(int i = 1 ; i < n ; i++)
        {
            for(int wt = 0 ; wt <= weight ; wt++)
            {
                int notTake = dp[i -1][wt]; //solve(i - 1, weight, weights, vals, dp);
                int take = (int) -1e7;

                if(wt >= weights[i])
                {
                    take = vals[i] + dp[i][wt - weights[i]]; //solve(i, weight - weights[i], weights, vals, dp);
                }

                dp[i][wt] = Math.max(notTake, take);
            }
        }
        return dp[n - 1][weight];
    }
}
