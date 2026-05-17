package DP.LIS.longest_IncreasingSubSeqLen.wayOne;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int len = lengthOfLIS(nums);
        System.out.println(len);
    }

    private static int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(0, -1, nums, dp);
    }

    private static int solve(int i, int prev, int[] nums, int[][] dp)
    {
        //base
        if(i == nums.length)
        {
            return 0;
        }

        if(dp[i][prev + 1] != -1) return dp[i][prev + 1];

        int len =  solve(i + 1, prev, nums, dp);

        if(prev == -1 || nums[i] > nums[prev])
        {
            len = Math.max(1 + solve(i + 1, i, nums, dp), len);
        }
        return dp[i][prev + 1] = len;
    }
}
