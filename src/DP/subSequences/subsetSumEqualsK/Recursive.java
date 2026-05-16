package DP.subSequences.subsetSumEqualsK;

public class Recursive
{
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1};
        int target = 4;

        boolean check = isSubsetPresentEqualsK(nums, target);

        System.out.println(check);
    }

    private static boolean isSubsetPresentEqualsK(int[] nums, int target)
    {
        return solve(nums.length - 1, nums, target);
    }

    private static boolean solve(int i, int[] nums, int target)
    {
        if(target == 0) return true;
        if(i == 0) return nums[0] == target;

        boolean notTaken = solve(i - 1, nums, target);

        boolean taken = false;

        if(nums[i] <= target)
        {
            taken = solve(i - 1, nums, target - nums[i]);
        }

        return taken | notTaken;
    }
}
