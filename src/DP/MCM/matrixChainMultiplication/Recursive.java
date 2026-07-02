package DP.MCM.matrixChainMultiplication;

import java.util.Arrays;

public class Recursive
{
    public static void main(String[] args) {

        int[] nums = {10, 20, 30, 40, 30};
        int ans = minimumTotalOperations(nums);

        System.out.println(ans);
    }

    private static int  minimumTotalOperations(int[] nums)
    {
        return solve(1, nums.length - 1, nums);
    }

    private static int solve(int start, int end, int[] nums)
    {
        if(start == end) return 0;
        int min = (int)1e7;

        for(int k = start ; k < end ; k++)
        {
            int step = (nums[start - 1] * nums[k] * nums[end]) + solve(start, k, nums) + solve(k + 1, end, nums);
            min = Math.min(min, step);
        }
        return min;
    }
}
