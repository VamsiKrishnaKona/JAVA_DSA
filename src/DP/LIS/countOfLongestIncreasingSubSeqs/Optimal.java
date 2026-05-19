package DP.LIS.countOfLongestIncreasingSubSeqs;

import java.util.Arrays;

public class Optimal
{
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};

        int len = findNumberOfLIS(nums);
        System.out.println(len);
    }

    private static int findNumberOfLIS(int[] nums)
    {
        int n =  nums.length;

        int[] dp  = new int[n];
        int[] count =  new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = -1;
        for(int i = 0; i < n; i++)
        {
            for(int prev = 0 ; prev < i ; prev++)
            {
                if(nums[i] > nums[prev] && 1 + dp[prev] > dp[i])
                {
                    dp[i] = 1 + dp[prev];
                    count[i] = count[prev];
                }
                else if(nums[i] > nums[prev] && 1 + dp[prev] == dp[i])
                {
                    count[i] += count[prev];
                }
            }
            max = Math.max(max, dp[i]);
        }

        int nos =  0;

        for(int i = 0 ; i < n; i++)
        {
            if(dp[i] == max) nos += count[i];
        }

        return nos;
    }
}
