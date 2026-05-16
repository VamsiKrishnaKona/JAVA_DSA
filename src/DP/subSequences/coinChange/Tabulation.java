package DP.subSequences.coinChange;

public class Tabulation
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

        for(int t = 0 ; t <= target ; t++)
        {
            if (t % nums[0] == 0) dp[0][t] = t / nums[0];
            else dp[0][t] = (int) 1e9;
        }

        for(int ind = 1 ; ind < n ; ind++)
        {
            for(int t = 0 ; t <= target ; t++)
            {
                int notTake = dp[ind - 1][t]; //solve(ind - 1, target, nums, dp);
                int take = (int) 1e9;

                if(nums[ind] <= t)
                    take = 1 + dp[ind][t - nums[ind]]; //solve(ind, target - nums[ind], nums, dp);

                dp[ind][t] =  Math.min(notTake, take);
            }
        }

        int ans = dp[n - 1][target];
        if(ans >= 1e9) return -1;
        return ans;
    }
}
