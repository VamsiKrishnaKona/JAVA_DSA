package binarySearch.Easy;

import java.util.ArrayList;
import java.util.List;

public class First_And_Last_Occurrence
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 8, 8, 8, 8, 10};
        int target = 8;

        List<Integer> indices = findOccurrence(nums, target);

        System.out.println(indices);
    }

    private static List<Integer> findOccurrence(int[] nums, int target)
    {
        List<Integer> indices = new ArrayList<>();

        indices.add(first(nums, target));
        indices.add(last(nums, target));

        return indices;
    }

    private static int first(int[] nums, int target)
    {
        int first = -1;

        int start = 0;
        int end = nums.length - 1;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(target <= nums[mid])
            {
                first = mid;
                end = mid - 1;
            }
            else if(target > nums[mid])
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return first;
    }

    private static int last(int[] nums, int target)
    {
        int last = -1;

        int start = 0;
        int end = nums.length - 1;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(target >= nums[mid])
            {
                last = mid;
                start = mid + 1;
            }
            else if(target < nums[mid])
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return last;
    }
}
