package binarySearch.medium.aggressiveCows;

import java.util.*;

public class BruteForce
{
    private static boolean possible(int[] nums, int cows, int distance)
    {
        int cowsPlaced = 1, lastPlaced = nums[0];

        for(int i = 1 ; i < nums.length ; i++)
        {
            if(nums[i] - lastPlaced >= distance)
            {
                cowsPlaced += 1;
                lastPlaced = nums[i];
            }
        }

        if(cowsPlaced >= cows) return true;

        return false;
    }

    private static int findMaxOfMinDistances(int[] nums, int cows)
    {
        if(cows < 2) return -1;

        Arrays.sort(nums);

        int maxOfMinDistance = -1;

        int maxDistance = nums[nums.length - 1] - nums[0];

        for(int i = 1 ; i <= maxDistance ; i++)
        {
            if(possible(nums, cows , i))
            {
                maxOfMinDistance = i;
            }
        }
        return maxOfMinDistance;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{0, 3, 4, 7, 9, 10};
        int cows = 4;

        int maxOfMinDistances = findMaxOfMinDistances(nums, cows);

        System.out.println(maxOfMinDistances);
    }
}
