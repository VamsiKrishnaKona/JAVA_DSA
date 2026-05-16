package DP.subSequences.coinChange;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args)
    {

        int[] nums = {1, 2, 5};
        int target = 11;

        int coinsUsed = findCoinsRequired(nums, target);

        System.out.println(coinsUsed);
    }

    private static int findCoinsRequired(int[] nums, int target)
    {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        for(int[] arr : dp) Arrays.fill(arr, -1);
        return solve(n - 1, target, nums, dp);
    }

    private static int solve(int ind, int target, int[] nums, int[][] dp)
    {
        if(ind == 0)
        {
            if(target % nums[ind] == 0) return target / nums[ind];
            else return (int) 1e9;
        }
        if(dp[ind][target] != -1) return dp[ind][target];

        int notTake = solve(ind - 1, target, nums, dp);
        int take = (int) 1e9;

        if(nums[ind] <= target)
            take = 1 + solve(ind, target - nums[ind], nums, dp);

        return dp[ind][target] =  Math.min(notTake, take);
    }
}
