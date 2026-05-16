package DP.subSequences.coinChangeTwo;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int target = 4;

        int ans = findCoinChanges(nums, target);

        System.out.println(ans);
    }

    private static  int findCoinChanges(int[] nums, int target)
    {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return solve(n - 1, target, nums, dp);
    }

    private static int solve(int ind,  int target, int[] nums, int[][] dp)
    {
        if(ind == 0)
        {
            if(target % nums[0] == 0) return 1;
            else return 0;
        }

        if(dp[ind][target] != -1) return dp[ind][target];

        int notTake = solve(ind - 1, target, nums, dp);
        int take = 0;

        if(nums[ind] <= target) take = solve(ind, target - nums[ind], nums, dp);

        return dp[ind][target] = take + notTake;
    }
}
