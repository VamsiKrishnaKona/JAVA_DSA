package binarySearch.medium.aggressiveCows;

<<<<<<< HEAD
import java.util.Arrays;
=======
import java.util.*;
>>>>>>> origin/krishna

public class Optimal
{
    private static boolean possible(int[] nums, int cows, int distance)
    {
        int cowsPlaced = 1;
        int lastPlaced = nums[0];

        for(int i = 1 ; i < nums.length ; i++)
        {
            if(nums[i] - lastPlaced >= distance)
            {
                cowsPlaced += 1;
                lastPlaced = nums[i];
            }
        }

        if(cowsPlaced >= cows)
        {
            return true;
        }

        return false;
    }

    private static int findMaxOfMinDistances(int[] nums, int cows)
    {
        if(cows < 2) return -1;

        Arrays.sort(nums);

        int maxOfMinDistance = -1;

        int start = 1;
        int end = nums[nums.length - 1] - nums[0];

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(possible(nums, cows, mid))
            {
                maxOfMinDistance = mid;
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }

        return maxOfMinDistance;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{0, 3, 4, 7, 9, 10};
        int cows = 4;

        //output will be 3
        int maxOfMinDistances = findMaxOfMinDistances(nums, cows);

        System.out.println(maxOfMinDistances);
    }
}
