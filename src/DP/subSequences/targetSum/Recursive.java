package DP.subSequences.targetSum;

public class Recursive
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
        return solve(n - 1, 0, target, nums);
    }

    private static int solve(int i, int sum, int target, int[] nums)
    {
        if(i == 0)
        {
            if(sum + nums[i] == target && sum - nums[i] == target) return 2;
            if(sum + nums[i] == target || sum - nums[i] == target) return 1;
            else return 0;
        }

        int add = solve(i - 1, sum + nums[i], target, nums);
        int minus = solve(i - 1, sum - nums[i], target, nums);

        return add + minus;
    }
}
