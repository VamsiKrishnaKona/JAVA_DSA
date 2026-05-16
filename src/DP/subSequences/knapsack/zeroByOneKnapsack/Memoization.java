package DP.subSequences.knapsack.zeroByOneKnapsack;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args)
    {
        int sackWeight = 5;
        int[] weights = {5, 2, 2, 3};
        int[] values = {10, 40, 30, 50};

        int maximumSack = fillTheSack(sackWeight, weights, values);

        System.out.println(maximumSack);
    }

    private static int fillTheSack(int sackWeight, int[] weights, int[] values)
    {
        int n =  weights.length;
        int[][] dp = new int[n][sackWeight+1];

        for(var row : dp) Arrays.fill(row, -1);
        return solve(n - 1, sackWeight, weights, values, dp);
    }

    private static int solve(int i,  int sackWeight, int[] weights, int[] values, int[][] dp)
    {
        if(sackWeight == 0) return 0;

        if(i == 0)
        {
            if(weights[0] == sackWeight ) return values[0];
            else return 0;
        }

        if(dp[i][sackWeight] != -1) return dp[i][sackWeight];

        int notTaken = (int) -1e7;
        int Taken = (int) -1e7;

        notTaken = solve(i - 1, sackWeight, weights, values, dp);

        if(weights[i] <= sackWeight)
        {
            Taken = values[i] + solve(i - 1, sackWeight - weights[i], weights, values, dp);
        }

        return dp[i][sackWeight] = Math.max(notTaken, Taken);
    }
}
