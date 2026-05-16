package DP.oneD.frogJump;

public class Recursive
{
    public static void main(String[] args)
    {
        int[] heights = {10, 20, 30};

        int energyDrained = findDrainedEnergy(heights);

        System.out.println(energyDrained);
    }

    private static int findDrainedEnergy(int[] heights)
    {
        return f(heights, heights.length - 1);
    }

    private static int f(int[] heights, int index)
    {
        if(index == 0)
        {
            return 0;
        }
        int left = 0;
        int right = Integer.MAX_VALUE;

        left = f(heights, index - 1) + Math.abs(heights[index] - heights[index - 1]);

        if(index > 1)
        {
            right = f(heights, index - 2) + Math.abs(heights[index] - heights[index - 2]);
        }

        return Math.min(left, right);
    }
}


