package DP.oneD.frogJumpWithKJumps;

public class recursive
{
    public static void main(String[] args)
    {
        int[] heights = {10, 20, 30, 10};
        int k = 3;

        int energyDrained = findDrainedEnergy(heights, k);

        System.out.println(energyDrained);
    }

    private static int findDrainedEnergy(int[] heights, int k)
    {
        return f(heights, heights.length - 1, k);
    }

    private static int f(int[] heights, int index, int k)
    {
        if(index <= 0) return 0;
        int min = Integer.MAX_VALUE;
        int it = 0;

        for(int i = 1 ; i <= k ; i++)
        {
            if(index - i >= 0)
            {
                it = f(heights, index - i, k) + Math.abs(heights[index] - heights[index - i]);
                min = Math.min(min, it);
            }
            else
                break;
        }
        return min;
    }
}
