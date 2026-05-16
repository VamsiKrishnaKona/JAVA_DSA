package DP.oneD.frogJump;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args)
    {
        int[] heights = {10, 20, 30, 10};

        int energyDrained = findDrainedEnergy(heights);

        System.out.println(energyDrained);
    }

    private static int findDrainedEnergy(int[] heights)
    {
        int[] dp = new int[heights.length + 1];
        Arrays.fill(dp, -1);
        return f(dp, heights, heights.length - 1);
    }

    private static int f(int[] dp, int[] heights, int index)
    {
        if(index == 0) return 0;

        if(dp[index] != -1) return dp[index];
        int left = 0;
        int right = Integer.MAX_VALUE;

        left = f(dp, heights, index - 1) + Math.abs(heights[index] - heights[index - 1]);

        if(index > 1)
        {
            right = f(dp, heights, index - 2) + Math.abs(heights[index] - heights[index - 2]);
        }

        return dp[index] = Math.min(left, right);
    }
}
