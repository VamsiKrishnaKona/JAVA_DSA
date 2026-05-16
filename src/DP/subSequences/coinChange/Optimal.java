package DP.subSequences.coinChange;

public class Optimal
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
        int[] prev = new int[target + 1];

        for(int t = 0 ; t <= target ; t++)
        {
            if (t % nums[0] == 0) prev[t] = t / nums[0];
            else prev[t] = (int) 1e9;
        }

        for(int ind = 1 ; ind < n ; ind++)
        {
            int[] curr = new int[target + 1];
            for(int t = 0 ; t <= target ; t++)
            {
                int notTake = prev[t]; //solve(ind - 1, target, nums, dp);
                int take = (int) 1e9;

                if(nums[ind] <= t)
                    take = 1 + curr[t - nums[ind]]; //solve(ind, target - nums[ind], nums, dp);

                curr[t] =  Math.min(notTake, take);
            }
            prev = curr;
        }

        int ans = prev[target];
        if(ans >= 1e9) return -1;
        return ans;
    }
}
