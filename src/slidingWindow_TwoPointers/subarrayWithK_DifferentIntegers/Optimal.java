package slidingWindow_TwoPointers.subarrayWithK_DifferentIntegers;

import java.util.HashMap;
import java.util.Map;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = {1,2,1,3, 4};
        int k = 3;

        int count = findSubArraysCount(nums, k) - findSubArraysCount(nums, k - 1);
        System.out.print(count);
    }

    private static int findSubArraysCount(int[] nums, int k)
    {
        if(k < 0) return 0;

        int n = nums.length;

        int l = 0, r = 0, count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while(r < n)
        {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while(map.size() > k)
            {
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }

            count += r - l + 1;
            r++;
        }
        return count;
    }
}
