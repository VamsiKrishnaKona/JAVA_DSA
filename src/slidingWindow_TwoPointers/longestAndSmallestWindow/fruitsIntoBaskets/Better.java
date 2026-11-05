package slidingWindow_TwoPointers.longestAndSmallestWindow.fruitsIntoBaskets;

import java.util.HashMap;
import java.util.Map;

public class Better
{
    public static void main(String[] args)
    {
        int[] nums = {0, 1, 1, 2, 1};

        int fruitsCount = collectFruits(nums);
        System.out.print(fruitsCount);
    }

    private static int collectFruits(int[] nums)
    {
        int n = nums.length;
        int maxCount = 0, r = 0, l = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while(r < n)
        {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while(map.size() > 2)
            {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            maxCount = Math.max(maxCount, r - l + 1);
            r++;
        }
        return maxCount;
    }
}
