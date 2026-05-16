package DP.subSequences.knapsack.zeroByOneKnapsack;

public class Optimal
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
        int[] prev = new int[maxWeight + 1];

        for(int w = weights[0] ; w <= maxWeight ; w++) prev[w] = val[0];

        for(int ind = 1 ; ind < n ; ind++)
        {
            int[] curr = new int[maxWeight+1];
            for(int w = 0 ; w <= maxWeight; w++)
            {
                int notTaken = prev[w];
                int Taken = (int) -1e7;

                if(weights[ind] <= w)
                {
                    Taken = val[ind] + prev[w - weights[ind]];
                }

                curr[w] = Math.max(notTaken, Taken);
            }
            prev = curr;
        }

        return prev[maxWeight];
    }
}
