package DP.MCM.matrixChainMultiplication;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args) {

        int[] nums = {10, 20, 30, 40, 30};
        int ans = minimumTotalOperations(nums);

        System.out.println(ans);
    }

    private static int  minimumTotalOperations(int[] nums)
    {
        int[][] dp = new int[nums.length][nums.length];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(1, nums.length - 1, nums, dp);
    }

    private static int solve(int start, int end, int[] nums, int[][] dp)
    {
        if(start == end) return 0;
        int min = (int)1e7;
        if(dp[start][end] != -1) return dp[start][end];
        for(int k = start ; k < end ; k++)
        {
            int step = (nums[start - 1] * nums[k] * nums[end]) + solve(start, k, nums, dp) + solve(k + 1, end, nums, dp);
            min = Math.min(min, step);
        }
        return dp[start][end] = min;
    }
}
