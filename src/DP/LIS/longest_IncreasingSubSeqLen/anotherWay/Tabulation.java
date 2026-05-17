package DP.LIS.longest_IncreasingSubSeqLen.anotherWay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hashArray = new int[n];
        int lastInd = 0;
        int max = 1;
        for(int i = 0 ; i < n  ; i++)
        {
            hashArray[i] = i;
            for(int prev = 0 ; prev < i ; prev++)
            {
                if(nums[prev] < nums[i] && 1 + dp[prev] > dp[i])
                {
                    dp[i] = 1 + dp[prev];
                    hashArray[i] = prev;
                }
            }
            if(dp[i] > max)
            {
                max = dp[i];
                lastInd = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.addFirst(nums[lastInd]);
        while(hashArray[lastInd] != lastInd)
        {
            lastInd = hashArray[lastInd];
            list.addFirst(nums[lastInd]);
        }

        System.out.println(list);

        return max;
    }
}
