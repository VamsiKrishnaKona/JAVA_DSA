package DP.twoD.ninjaTraining;

import java.util.Arrays;

public class tabulation
{
    public static void main(String[] args)
    {
        int[][] training = {
                {10, 50, 1},
                {5, 100, 11},
                {9, 70, 100}
        };

        int maxPoints = findMaxPoints(training);

        System.out.println(maxPoints);
    }

    private static int findMaxPoints(int[][] nums)
    {
        int n = nums.length;
        int[][] dp = new int[n][4];

        for(int[] a : dp)
        {
            Arrays.fill(a, -1);
        }

        dp[0][0] = Math.max(nums[0][1], nums[0][2]);
        dp[0][1] = Math.max(nums[0][0], nums[0][2]);
        dp[0][2] = Math.max(nums[0][0], nums[0][1]);
        dp[0][3] = Math.max(nums[0][0], Math.max(nums[0][1], nums[0][2]));

        for(int day = 1 ; day < n ; day++)
        {
            for(int last = 0 ; last < 4 ; last++)
            {
                for(int i = 0 ; i < 3 ; i++)
                {
                    if(i != last)
                    {
                        int points = nums[day][i] + dp[day - 1][i];
                        dp[day][last] = Math.max(points, dp[day][last]);
                    }
                }
            }
        }

        return dp[n-1][3];
    }
}
