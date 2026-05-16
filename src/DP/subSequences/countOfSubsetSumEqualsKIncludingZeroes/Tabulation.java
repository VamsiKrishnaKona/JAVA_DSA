package DP.subSequences.countOfSubsetSumEqualsKIncludingZeroes;

public class Tabulation
{
    public static void main(String[] args) {

        int[] nums = {0, 0, 1};
        int target = 1;

        int check = isSubsetPresentEqualsK(nums, target);

        System.out.println(check);
    }

    private static int isSubsetPresentEqualsK(int[] nums, int target)
    {
        int[][] dp = new int[nums.length][target + 1];

        //for(int i = 0 ; i < nums.length ; i++) dp[i][0] = 1;

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

        return dp[nums.length - 1][target];
    }
}
