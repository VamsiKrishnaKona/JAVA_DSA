package DP.subSequences.countOfSubsetSumEqualsK;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1};
        int target = 4;

        int check = isSubsetPresentEqualsK(nums, target);

        System.out.println(check);
    }

    private static int isSubsetPresentEqualsK(int[] nums, int target)
    {
        int[][] dp = new int[nums.length][target + 1];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return solve(nums.length - 1, nums, target, dp);
    }

    private static int solve(int i, int[] nums, int target, int[][] dp)
    {
        //base functions
        if(target == 0) return 1;
        if(i == 0 && nums[0] == target)
        {
            return 1;
        }
        if(i == 0) return 0;
        if(dp[i][target] != -1) return  dp[i][target];

        //recursions
        int notTaken = solve(i - 1, nums, target, dp);

        int taken = 0;

        if(nums[i] <= target)
        {
            taken = solve(i - 1, nums, target - nums[i], dp);
        }

        return dp[i][target] = taken + notTaken;
    }
}
