package DP.subSequences.subsetSumEqualsK;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1};
        int target = 4;

        boolean check = isSubsetPresentEqualsK(nums, target);

        System.out.println(check);
    }

    private static boolean isSubsetPresentEqualsK(int[] nums, int target)
    {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return solve(nums.length - 1, nums, target, dp);
    }

    private static boolean solve(int i, int[] nums, int target, int[][] dp)
    {
        if(target == 0) return true;
        if(i == 0) return nums[0] == target;
        if(dp[i][target] != -1) return dp[i][target] == 1;

        boolean notTaken = solve(i - 1, nums, target, dp);

        boolean taken = false;

        if(nums[i] <= target)
        {
            taken = solve(i - 1, nums, target - nums[i], dp);
        }

        dp[i][target] = (taken || notTaken) ? 1 : 0;
        return dp[i][target] == 1;
    }
}
