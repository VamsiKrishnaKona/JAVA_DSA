package DP.LIS.longestDivisibleSubSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = {1, 16, 7, 8, 4};

        List<Integer> list = largestDivisibleSubset(nums);

        System.out.println(list);
    }

    private static List<Integer> largestDivisibleSubset(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        int lastInd = 0;
        int max = 0;

        for(int i = 0 ; i < n ; i++)
        {
            hash[i] = i;
            for(int prev = 0 ; prev < i ; prev++)
            {
                if(nums[i] % nums[prev] == 0 || nums[prev] % nums[i] == 0 && dp[i] < 1 + dp[prev])
                {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i] > max)
            {
                max = dp[i];
                lastInd = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.addLast(nums[lastInd]);

        while(hash[lastInd] != lastInd)
        {
            lastInd = hash[lastInd];
            list.addLast(nums[lastInd]);
        }

        Collections.reverse(list);

        return list;
    }
}
