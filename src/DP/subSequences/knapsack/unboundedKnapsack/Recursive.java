package DP.subSequences.knapsack.unboundedKnapsack;

public class Recursive
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
        return solve(n - 1, weight, weights, vals);
    }

    private static int solve(int i, int weight, int[] weights, int[] vals)
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

        int notTake = solve(i - 1, weight, weights, vals);
        int take = (int) -1e7;

        if(weight >= weights[i])
        {
            take = vals[i] + solve(i, weight - weights[i], weights, vals);
        }

        return Math.max(notTake, take);
    }
}
