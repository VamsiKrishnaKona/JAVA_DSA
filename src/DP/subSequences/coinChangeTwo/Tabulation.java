package DP.subSequences.coinChangeTwo;

import java.util.Arrays;

public class Tabulation
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

        for(int t = 0 ; t <= target ; t++)
        {
            if(t % nums[0] == 0) dp[0][t] = 1;
            else  dp[0][t] = 0;
        }

        for(int ind = 1 ; ind < n ; ind++)
        {
            for(int t = 0 ; t <= target ; t++)
            {
                int notTake = dp[ind - 1][t]; //solve(ind - 1, target, nums, dp);
                int take = 0;

                if(nums[ind] <= t) take =  dp[ind][t - nums[ind]]; //solve(ind, target - nums[ind], nums, dp);

                dp[ind][t] = take + notTake;
            }
        }

        return dp[n - 1][target];
    }
}
