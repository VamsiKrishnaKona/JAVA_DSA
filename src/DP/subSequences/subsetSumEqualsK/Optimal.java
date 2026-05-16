package DP.subSequences.subsetSumEqualsK;

public class Optimal
{
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1};
        int target = 4;

        boolean check = isSubsetPresentEqualsK(nums, target);

        System.out.println(check);
    }

    private static boolean isSubsetPresentEqualsK(int[] nums, int target)
    {
        int n = nums.length;
        boolean[] prev = new boolean[target + 1];
        boolean[] curr = new boolean[target + 1];
        prev[0] = true;
        curr[0] = true;
        if(nums[0] <= target ) prev[nums[0]] = true;

        for(int i = 1; i < n; i++)
        {
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
