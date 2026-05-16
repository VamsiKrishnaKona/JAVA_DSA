package DP.oneD.frogJump;

public class Optimal
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

        int prev = 0;
        int prev2 = 0;
        int left;
        int right = Integer.MAX_VALUE;
        for(int i = 1 ; i < n ; i++)
        {
            left = prev + Math.abs(heights[i] - heights[i - 1]);

            if(i > 1) right = prev2 + Math.abs(heights[i] - heights[i - 2]);

            int curr = Math.min(left, right);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
