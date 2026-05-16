package DP.subSequences.countOfSubsetSumEqualsK;

public class Recursive
{
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1};
        int target = 4;

        int check = isSubsetPresentEqualsK(nums, target);

        System.out.println(check);
    }

    private static int isSubsetPresentEqualsK(int[] nums, int target)
    {
        return solve(nums.length - 1, nums, target);
    }

    private static int solve(int i, int[] nums, int target)
    {
        if(target == 0) return 1;
        if(i == 0 && nums[0] == target)
        {
            return 1;
        }
        if(i == 0) return 0;

        int notTaken = solve(i - 1, nums, target);

        int taken = 0;

        if(nums[i] <= target)
        {
            taken = solve(i - 1, nums, target - nums[i]);
        }

        return taken + notTaken;
    }
}
