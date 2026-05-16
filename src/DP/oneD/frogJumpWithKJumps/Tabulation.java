package DP.oneD.frogJumpWithKJumps;

public class Tabulation
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
        dp[0] = 0;

        int it = 0;
        for(int i = 1; i < heights.length; i++)
        {
            int min = Integer.MAX_VALUE;
            for(int j = 1 ; j <= k ; j++)
            {
                if(i - j >= 0)
                {
                    it = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    min = Math.min(min, it);
                }
                else
                {
                    break;
                }

            }
            dp[i] = min;
        }
        return dp[heights.length - 1];
    }


}
