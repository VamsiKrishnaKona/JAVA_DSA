package DP.oneD.frogJumpWithKJumps;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args)
    {
        int[] heights = {10, 20, 30, 10};
        int k = 2;

        int energyDrained = findDrainedEnergy(heights, k);

        System.out.println(energyDrained);
    }

    private static int findDrainedEnergy(int[] heights, int k)
    {
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        return f(heights, dp, heights.length - 1, k);
    }

    private static int f(int[] heights, int[] dp, int index, int k)
    {
        if(index <= 0) return 0;
        if(dp[index] != -1) return dp[index];

        int min = Integer.MAX_VALUE;
        int it = 0;

        for(int i = 1 ; i <= k ; i++)
        {
            if(index - i >= 0)
            {
                it = f(heights, dp, index - i, k) + Math.abs(heights[index] - heights[index - i]);
                min = Math.min(min, it);
            }
            else
                break;
        }
        return dp[index] = min;
    }
}
