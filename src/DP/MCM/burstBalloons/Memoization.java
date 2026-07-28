package DP.MCM.burstBalloons;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Memoization
{
    public static void main(String[] args)
    {
        int[] nums = {3,1,5,8};
        int ans = maxCoins(nums);
        System.out.println(ans);
    }

    private static int maxCoins(int[] nums)
    {
        int len = nums.length;
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        numbers.add(0, 1);
        numbers.add(numbers.size(), 1);

        int[][] dp = new int[len + 1][len + 1];

        return solve(1, len, numbers, dp);
    }

    private static int solve(int i, int j, List<Integer> nums, int[][] dp)
    {
        if(i > j) return 0;

        if(dp[i][j] != 0) return dp[i][j];

        int maxi = Integer.MIN_VALUE;
        for(int ind = i ; ind <= j ; ind++)
        {
            int value = nums.get(i - 1) * nums.get(ind) * nums.get(j + 1)
                    + solve(i, ind - 1, nums, dp) + solve(ind + 1, j, nums, dp);

            maxi = Math.max(maxi, value);
        }
        return dp[i][j] = maxi;
    }
}
