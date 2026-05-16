package DP.subSequences.coinChange;

public class Recursive
{
    public static void main(String[] args)
    {

        int[] nums = {1, 2, 5};
        int target = 11;

        int coinsUsed = findCoinsRequired(nums, target);

        System.out.println(coinsUsed);
    }

    private static int findCoinsRequired(int[] nums, int target)
    {
        int n = nums.length;

        return solve(n - 1, target, nums);
    }

    private static int solve(int ind, int target, int[] nums)
    {
        if(ind == 0)
        {
            if(target % nums[ind] == 0) return target / nums[ind];
            else return (int) 1e9;
        }

        int notTake = solve(ind - 1, target, nums);
        int take = (int) 1e9;

        if(nums[ind] <= target)
            take = 1 + solve(ind, target - nums[ind], nums);

        return Math.min(notTake, take);
    }
}
