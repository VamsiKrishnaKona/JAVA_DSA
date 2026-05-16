package DP.subSequences.coinChangeTwo;

public class Recursive
{
    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 3};
        int target = 4;

        int ans = findCoinChanges(nums, target);

        System.out.println(ans);
    }

    private static  int findCoinChanges(int[] nums, int target)
    {
        int n = nums.length;
        return solve(n - 1, target, nums);
    }

    private static int solve(int ind,  int target, int[] nums)
    {
        if(ind == 0)
        {
            if(target % nums[0] == 0) return 1;
            else return 0;
        }

        int notTake = solve(ind - 1, target, nums);
        int take = 0;

        if(nums[ind] <= target) take = solve(ind, target - nums[ind], nums);

        return take + notTake;
    }
}
