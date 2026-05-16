package DP.subSequences.countPartitionsWithGivenDifference;

public class Tabulation
{
    private static final int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {

        int[] nums = {7, 3, 5, 2};
        int target = 3;

        int check = findPartitionCountEqualsGivenTarget(nums, target);

        System.out.println(check);
    }

    private static int findPartitionCountEqualsGivenTarget(int[] nums, int target)
    {
        int totalSum = 0;

        for(int num : nums) totalSum += num;

        if(totalSum - target < 0 || (totalSum - target) % 2 != 0) return 0;

        return isSubsetPresentEqualsK(nums, (totalSum - target) / 2);
    }

    private static int isSubsetPresentEqualsK(int[] nums, int target)
    {
        int[][] dp = new int[nums.length][target + 1];

        if(nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if(nums[0] != 0 && nums[0] <= target) dp[0][nums[0]] = 1;

        for(int i = 1 ; i < nums.length ; i++)
        {
            for(int j = 0 ; j <= target ; j++)
            {
                int notTaken = dp[i - 1][j];
                int taken = 0;
                if(nums[i] <= j)
                {
                    taken = dp[i - 1][j - nums[i]];
                }

                dp[i][j] = notTaken + taken;
            }
        }

        return dp[nums.length - 1][target] % MOD ;
    }
}
