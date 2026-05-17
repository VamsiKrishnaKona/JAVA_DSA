package DP.LIS.longest_IncreasingSubSeqLen.wayOne;

public class Recursive
{
    public static void main(String[] args) {
        int[] nums = {-2, -1};

        Recursive obj = new Recursive();
        int len = obj.lengthOfLIS(nums);
        System.out.println(len);
    }

    private int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        return solve(0, -1, nums);
    }

    private int solve(int i, int prev, int[] nums)
    {
        //base
        if(i == nums.length - 1)
        {
            if(prev >= 0 && nums[i] > nums[prev]) return 1;
            else return 0;
        }

        int take = (int) -1e7;

        if(prev == -1 || nums[i] > nums[prev])
        {
            take = 1 + solve(i + 1, i, nums);
        }

        int notTake = solve(i + 1, prev, nums);

        return Math.max(take, notTake);
    }
}
