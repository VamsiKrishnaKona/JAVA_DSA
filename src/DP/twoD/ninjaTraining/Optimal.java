package DP.twoD.ninjaTraining;

import java.util.Arrays;

public class Optimal
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
        int[] prev = new int[4];

        prev[0] = Math.max(nums[0][1], nums[0][2]);
        prev[1] = Math.max(nums[0][0], nums[0][2]);
        prev[2] = Math.max(nums[0][0], nums[0][1]);
        prev[3] = Math.max(nums[0][0], Math.max(nums[0][1], nums[0][2]));

        for(int day = 1 ; day < n ; day++)
        {
            int[] temp = new int[4];
            for(int last = 0 ; last < 4 ; last++)
            {
                for(int i = 0 ; i < 3 ; i++)
                {
                    if(i != last)
                    {
                        int points = nums[day][i] + prev[i];
                        temp[last] = Math.max(points, temp[last]);
                    }
                }
            }
            prev = temp;
        }

        return prev[3];
    }
}
