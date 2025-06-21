package arrays.hard.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> triplets = findTriplet(arr);

        for (List<Integer> i : triplets)
        {
            System.out.println(i);
        }
    }

    private static List<List<Integer>> findTriplet(int[] nums)
    {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++)
        {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int right = nums.length - 1;
            int left = i + 1;


            while (left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0)
                {
                    left++;
                }
                else if(sum > 0)
                {
                    right--;
                }
                else
                {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[left], nums[right]);
                    triplets.add(triplet);
                    right--;
                    left++;

                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return triplets;
    }
}
