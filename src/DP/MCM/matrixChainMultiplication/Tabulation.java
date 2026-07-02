package DP.MCM.matrixChainMultiplication;

import java.util.Arrays;

public class Tabulation
{
    public static void main(String[] args) {

        int[] nums = {10, 20, 30, 40, 30};
        int ans = minimumTotalOperations(nums);

        System.out.println(ans);
    }

    private static int  minimumTotalOperations(int[] nums)
    {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int adj = 0 ; adj < n ; adj++) dp[adj][adj] = 0;

        for(int i = n - 1 ; i > 0 ; i--)
        {
            for(int j = i + 1 ; j < n ; j++)
            {
                int min = (int)1e7;
                for(int k = i ; k < j ; k++)
                {
                    int step = (nums[i - 1] * nums[k] * nums[j])
                            + dp[i][k]
                            +  dp[k + 1][j];
                    min = Math.min(min, step);
                }
                dp[i][j] = min;
            }
        }


        return dp[1][n - 1]; //solve(1, nums.length - 1, nums, dp);
    }
}
