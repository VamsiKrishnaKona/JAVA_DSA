package DP.subSequences.countPartitionsWithGivenDifference;

public class Optimal
{
    private static final int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {

        int[] nums = {7, 3, 5, 2};
        int target = 3;

        int check = findPartitionCountEqualsGivenTarget(nums, target);

        System.out.println(check);
    }

    private static int findPartitionCountEqualsGivenTarget(int[] nums, int target)
    {
        int totalSum = 0;

        for(int num : nums) totalSum += num;

        if(totalSum - target < 0 || (totalSum - target) % 2 != 0) return 0;

        return isSubsetPresentEqualsK(nums, (totalSum - target) / 2);
    }

    private static int isSubsetPresentEqualsK(int[] nums, int target)
    {
        int[] prev = new int[target + 1];

        if(nums[0] == 0) prev[0] = 2;
        else prev[0] = 1;

        if(nums[0] != 0 && nums[0] <= target) prev[nums[0]] = 1;

        for(int i = 1 ; i < nums.length ; i++)
        {
            int[] curr = new int[target + 1];
            for(int j = 0 ; j <= target ; j++)
            {
                int notTaken = prev[j];
                int taken = 0;
                if(nums[i] <= j)
                {
                    taken = prev[j - nums[i]];
                }

                curr[j] = notTaken + taken;
            }
            prev = curr;
        }

        return prev[target] % MOD ;
    }
}
