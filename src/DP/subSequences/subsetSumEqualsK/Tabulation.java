package DP.subSequences.subsetSumEqualsK;


public class Tabulation
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
        boolean[][] dp = new boolean[n][target + 1];

        for(int j = 0 ; j < n ; j++) dp[j][0] = true;
        dp[0][nums[0]] = true;

        for(int i = 1; i < n; i++)
        {
            for(int t = 1 ; t <= target ; t++)
            {
                boolean notTaken = dp[i - 1][t];
                boolean taken = false;
                if(nums[i] <= t)
                {
                    taken = dp[i - 1][t - nums[i]];
                }
                dp[i][t] = taken | notTaken;
            }
        }

        return dp[n - 1][target];
    }
}
