package DP.oneD.frogJump;

public class Tabulation
{
    public static void main(String[] args)
    {
        int[] heights = {10, 20, 30, 10};

        int energyDrained = findDrainedEnergy(heights);

        System.out.println(energyDrained);
    }

    private static int findDrainedEnergy(int[] heights)
    {
        int n = heights.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        int left = 0;
        int right = Integer.MAX_VALUE;
        for(int i = 1 ; i < n ; i++)
        {
            left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);

            if(i > 1) right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);

            dp[i] = Math.min(left, right);
        }
        return dp[n - 1];
    }
}
