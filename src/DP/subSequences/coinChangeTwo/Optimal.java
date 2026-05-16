package DP.subSequences.coinChangeTwo;

public class Optimal
{
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int target = 4;

        int ans = findCoinChanges(nums, target);

        System.out.println(ans);
    }

    private static  int findCoinChanges(int[] nums, int target)
    {
        int n = nums.length;
        int[] prev = new int[target+1];

        for(int t = 0 ; t <= target ; t++)
        {
            if(t % nums[0] == 0) prev[t] = 1;
        }

        for(int ind = 1 ; ind < n ; ind++)
        {
            int[] curr = new int[target + 1];
            for(int t = 0 ; t <= target ; t++)
            {
                int notTake = prev[t]; //solve(ind - 1, target, nums, dp);
                int take = 0;

                if(nums[ind] <= t) take =  curr[t - nums[ind]]; //solve(ind, target - nums[ind], nums, dp);

                curr[t] = take + notTake;
            }
            prev = curr;
        }

        return prev[target];
    }
}
