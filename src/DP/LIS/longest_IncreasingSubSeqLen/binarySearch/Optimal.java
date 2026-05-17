package DP.LIS.longest_IncreasingSubSeqLen.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = {1, 7, 8, 4, 5, 6, -1, 9};

        int length = lengthOfLIS(nums);

        System.out.println(length);
    }

    private static int lengthOfLIS(int[] nums)
    {
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i = 1; i < n; i++)
        {
            if(nums[i] > list.getLast())
            {
                list.add(nums[i]);
            }
            else
            {
                int index = lowerBound(nums[i], list);
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }

    private static int lowerBound(int num, List<Integer> list)
    {
        int start = 0;
        int end = list.size() - 1;

        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(list.get(mid) >= num)
            {
                ans = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }

        return ans;
    }
}
