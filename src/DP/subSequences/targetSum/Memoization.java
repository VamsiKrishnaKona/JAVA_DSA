package DP.subSequences.targetSum;

public class Memoization
{
    public static void main(String[] args)
    {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        int sums = findPossibilities(nums, target);
        System.out.println(sums);
    }

    private static int  findPossibilities(int[] nums, int target)
    {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        return solve(n - 1, target, nums);
    }

    private static int solve(int i, int target, int[] nums)
    {
        if(i == 0)
        {
            if((target + nums[i] == 0 || target + nums[i] == 2 * target) && (target - nums[i] == 0 || target - nums[i] == 2 * target)) return 2;

            if(target + nums[i] == 0 || target + nums[i] == 2 * target) return 1;
            if(target - nums[i] == 0 || target - nums[i] == 2 * target) return 1;
            else return 0;
        }
        int add = solve(i - 1, target + nums[i], nums);
        int minus = solve(i - 1, target - nums[i], nums);

        return add + minus;
    }
}
