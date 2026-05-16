package DP.subSequences.partitionASetIntoTwoSubsetsWithAbsoluteMinimumDifferenceSum;

public class Optimal
{
    public static void main(String[] args) {

        int[] nums = {2, 3, 7};

        int minDifference = findMinSumDifference(nums);

        System.out.println(minDifference);
    }

    private static int findMinSumDifference(int[] nums)
    {
        int n = nums.length;

        int totalSum = 0;
        for(int i = 0; i < n; i++) totalSum += nums[i];

        int target = totalSum;

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

        int min = (int) 1e8;
        for(int s1 = 0 ; s1 <= totalSum/2 ; s1++)
        {
            if(prev[s1])
            {
                min = Math.min(min, Math.abs((totalSum - s1) - s1));
            }
        }
        return min;
    }
}
