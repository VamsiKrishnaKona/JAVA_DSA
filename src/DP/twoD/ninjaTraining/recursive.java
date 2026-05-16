package DP.twoD.ninjaTraining;

public class recursive
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
        int day = training.length - 1;

        return findMaximumScored(training, day, -1);
    }

    private static int findMaximumScored(int[][] nums, int day, int last)
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

        int maxPoints = 0;

        for(int i = 0 ; i < nums[day].length ; i++)
        {
            if(last != i)
            {
                int points = nums[day][i] + findMaximumScored(nums, day - 1, i);
                maxPoints = Math.max(maxPoints, points);
            }
        }
        return maxPoints;
    }
}
