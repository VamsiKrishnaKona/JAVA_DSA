package DP.subSequences.knapsack.zeroByOneKnapsack;

public class Recursive
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

        return solve(n - 1, sackWeight, weights, values);
    }

    private static int solve(int i,  int sackWeight, int[] weights, int[] values)
    {
        if(sackWeight == 0) return 0;

        if(i == 0)
        {
            if(weights[0] == sackWeight ) return values[0];
            else return 0;
        }

        int notTaken = (int) -1e7;
        int Taken = (int) -1e7;

        notTaken = solve(i - 1, sackWeight, weights, values);

        if(weights[i] <= sackWeight)
        {
            Taken = values[i] + solve(i - 1, sackWeight - weights[i], weights, values);
        }

        return Math.max(notTaken, Taken);
    }
}
