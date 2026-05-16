package DP.subSequences.knapsack.unboundedKnapsack;

public class Optimal
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
        int[] prev = new int[weight + 1];

        for(int wt = weights[0] ; wt <= weight ; wt++)
        {
            prev[wt] = (wt / weights[0]) * vals[0];
        }

        for(int i = 1 ; i < n ; i++)
        {
            int[] curr = new int[weight + 1];
            for(int wt = 0 ; wt <= weight ; wt++)
            {
                int notTake = prev[wt]; //solve(i - 1, weight, weights, vals, dp);
                int take = (int) -1e7;

                if(wt >= weights[i])
                {
                    take = vals[i] + curr[wt - weights[i]]; //solve(i, weight - weights[i], weights, vals, dp);
                }

                curr[wt] = Math.max(notTake, take);
            }
            prev = curr;
        }
        return prev[weight];
    }
}
