package DP.subSequences.knapsack.zeroByOneKnapsack;

public class Tabulation
{
    public static void main(String[] args)
    {
        int sackWeight = 5;
        int[] weights = {5, 2, 2, 3};
        int[] values = {10, 40, 30, 50};

        int maximumSack = fillTheSack(sackWeight, weights, values);

        System.out.println(maximumSack);
    }

    private static int fillTheSack(int maxWeight, int[] weights, int[] val)
    {
        int n =  weights.length;
        int[][] dp = new int[n][maxWeight+1];

        for(int w = weights[0]; w <= maxWeight; w++) dp[0][w] = val[0];

        for(int ind = 1 ; ind < n ; ind++)
        {
            for(int w = 0 ; w <= maxWeight; w++)
            {
                int notTaken = dp[ind - 1][w];
                int Taken = (int) -1e7;

                if(weights[ind] <= w)
                {
                    Taken = val[ind] + dp[ind - 1][w - weights[ind]];
                }

                dp[ind][w] = Math.max(notTaken, Taken);
            }
        }

        return dp[n - 1][maxWeight];
    }
}
