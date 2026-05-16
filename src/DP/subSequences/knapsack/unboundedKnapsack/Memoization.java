package DP.subSequences.knapsack.unboundedKnapsack;

import java.util.Arrays;

public class Memoization
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
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(n - 1, weight, weights, vals, dp);
    }

    private static int solve(int i, int weight, int[] weights, int[] vals, int[][] dp)
    {
        if(weight == 0) return 0;

        if(i == 0)
        {
            if(weight >= weights[0])
            {
                return (weight / weights[0]) * vals[0];
            }
            else
            {
                return 0;
            }

        }

        if(dp[i][weight] != -1) return dp[i][weight];

        int notTake = solve(i - 1, weight, weights, vals, dp);
        int take = (int) -1e7;

        if(weight >= weights[i])
        {
            take = vals[i] + solve(i, weight - weights[i], weights, vals, dp);
        }

        return dp[i][weight] = Math.max(notTake, take);
    }
}
