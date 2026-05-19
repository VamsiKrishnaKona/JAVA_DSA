package DP.LIS.longestBitonicSubSeqLen;

import java.util.Arrays;

public class Optimal
{
    public static void main(String[] args) {
        int[] nums = {1, 11, 2, 10, 4, 5, 2, 1};

        int len = longestBitonicSubSeq(nums);
        System.out.println(len);
    }

    private static int longestBitonicSubSeq(int[] nums)
    {
        int n = nums.length;

        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);

        for(int i = 0; i < n; i++)
        {
            for(int prev = 0; prev < i; prev++)
            {
                if(nums[i] > nums[prev] && 1 + dp1[prev] > dp1[i])
                {
                    dp1[i] = 1 + dp1[prev];
                }
            }
        }

        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);

        for(int i = n - 1; i >= 0; i--)
        {
            for(int prev = n - 1; prev > i; prev--)
            {
                if(nums[i] > nums[prev] && 1 + dp2[prev] > dp2[i])
                {
                    dp2[i] = 1 + dp2[prev];
                }
            }
        }

        int max = 0;

        for(int i = 0; i < n; i++)
        {
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }

        return max;
    }
}
