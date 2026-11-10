package greedyAlgorithm.jumpGameTwo;

import java.util.Arrays;

public class Better
{
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};
        int minSteps = jumpGameTwo(nums);
        System.out.print(minSteps);
    }

    public static int jumpGameTwo(int[] nums)
    {
        int[][] dp = new int[nums.length][nums.length];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return jumpGameTwo(0, 0, nums, dp);
    }

    private static int jumpGameTwo(int i, int jumps, int[] nums, int[][] dp)
    {
        if(i == nums.length - 1) return jumps;
        int minCount = (int) 1e+5;
        if(nums[i] == 0 || i > nums.length - 1) return minCount;
        if(dp[i][jumps] != -1) return dp[i][jumps];

        for(int idx = 1 ; idx <= nums[i] ; idx++)
        {
            int steps = jumpGameTwo(i + idx, jumps + 1, nums, dp);
            minCount = Math.min(minCount, steps);
        }
        return dp[i][jumps] = minCount;
    }
}
