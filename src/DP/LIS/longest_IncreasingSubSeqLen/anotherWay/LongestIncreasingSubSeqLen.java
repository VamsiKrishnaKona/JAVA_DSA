package DP.LIS.longest_IncreasingSubSeqLen.anotherWay;

import java.util.Arrays;

public class LongestIncreasingSubSeqLen
{
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int len = lengthOfLIS(nums);
        System.out.println(len);
    }

    public static int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for(int i = 0 ; i < n ; i++)
        {
            for(int prev = 0 ; prev < i ; prev++)
            {
                if(nums[prev] < nums[i])
                {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
