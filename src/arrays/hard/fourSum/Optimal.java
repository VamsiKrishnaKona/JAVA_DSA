package arrays.hard.fourSum;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
=======
import java.util.*;
>>>>>>> origin/krishna

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{2,2,2,2,2};
        int target = 8;

        List<List<Integer>> fourlets = fourSum(nums, target);

        for(List<Integer> i : fourlets)
        {
            System.out.println(i);
        }
    }

    private static List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> fourlets = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1 ; j < nums.length ; j++)
            {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = nums.length - 1;

                while(left < right)
                {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[left];
                    sum += nums[right];

                    if(sum < target)
                    {
                        left++;
                    }
                    else if(sum > target)
                    {
                        right--;
                    }
                    else
                    {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        fourlets.add(temp);
                        left++;
                        right--;

                        while(left < right && nums[left] == nums[left - 1]) left++;
                        while(left < right && nums[right] == nums[right + 1]) right--;
                    }
                }

            }
        }
        return fourlets;
    }
}
