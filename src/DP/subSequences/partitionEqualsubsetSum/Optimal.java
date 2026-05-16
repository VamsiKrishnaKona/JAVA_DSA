package DP.subSequences.partitionEqualsubsetSum;

public class Optimal
{
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 3};

        boolean check = isPartitionPossible(nums);

        System.out.println(check);
    }

    private static boolean isPartitionPossible(int[] nums)
    {
        int n = nums.length;

        int totalSum = 0;

        for(int i = 0; i < n; i++) totalSum += nums[i];

        if((totalSum & 1) == 1) return false;

        int targetSum = totalSum / 2;

        return isSubsetPresentEqualsK(nums, targetSum);
    }

    private static boolean isSubsetPresentEqualsK(int[] nums, int target)
    {
        int n = nums.length;
        boolean[] prev = new boolean[target + 1];

        prev[0] = true;

        if(nums[0] <= target) prev[nums[0]] = true;

        for(int i = 1; i < n; i++)
        {
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for(int t = 1 ; t <= target ; t++)
            {
                boolean notTaken = prev[t];
                boolean taken = false;
                if(nums[i] <= t)
                {
                    taken = prev[t - nums[i]];
                }
                curr[t] = taken | notTaken;
            }
            prev = curr;
        }

        return prev[target];
    }
}
