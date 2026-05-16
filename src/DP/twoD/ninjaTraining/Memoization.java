package DP.twoD.ninjaTraining;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args) {

        int[][] training = {
                {10, 50, 1},
                {5, 100, 11},
                {9, 70, 100}
        };

        int maxPoints = findMaxPoints(training);

        System.out.println(maxPoints);
    }

    private static int findMaxPoints(int[][] training)
    {
        int day = training.length;
        int[][] dp = new int[day][4];

        for(int[] a : dp)
        {
            Arrays.fill(a, -1);
        }

        return findMaximumScored(training, day - 1, 3, dp);
    }

    // o(n * 4) * 3
    // o(dp) + o(n)
    private static int findMaximumScored(int[][] nums, int day, int last, int[][] dp)
    {
        if(day == 0)
        {
            int maxi = 0;
            for(int i = 0 ; i < nums[0].length ; i++)
            {
                if(i != last)
                {
                    maxi = Math.max(maxi, nums[day][i]);
                }
            }

            return maxi;
        }

        if(dp[day][last] != -1) return dp[day][last];

        int maxPoints = 0;

        for(int i = 0 ; i < nums[day].length ; i++)
        {
            if(last != i)
            {
                int points = nums[day][i] + findMaximumScored(nums, day - 1, i, dp);
                maxPoints = Math.max(maxPoints, points);
            }
        }
        return dp[day][last] = maxPoints;
    }
}
