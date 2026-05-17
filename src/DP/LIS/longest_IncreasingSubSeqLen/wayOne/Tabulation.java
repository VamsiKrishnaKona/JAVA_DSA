package DP.LIS.longest_IncreasingSubSeqLen.wayOne;

public class Tabulation
{
    public static void main(String[] args) {
    int[] nums = {10,9,2,5,3,7,101,18};
    int len = lengthOfLIS(nums);
    System.out.println(len);
}

    private static int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for(int i = n - 1 ; i >= 0 ; i--)
        {
            for(int prev = i - 1 ; prev >= -1 ; prev--)
            {
                int len = dp[i + 1][prev + 1];

                if(prev == -1 || nums[i] > nums[prev])
                {
                    len = Math.max(1 + dp[i + 1][i + 1], len);
                }

                dp[i][prev + 1] = len;
            }
        }
        return dp[0][0];
    }
}
