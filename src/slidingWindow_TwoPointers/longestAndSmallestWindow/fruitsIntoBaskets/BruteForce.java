package slidingWindow_TwoPointers.longestAndSmallestWindow.fruitsIntoBaskets;

import java.util.HashMap;
import java.util.Map;

public class BruteForce
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
        int maxCount = 0;
        for(int i = 0 ; i < n ; i++)
        {
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for(int j = i ; j < n ; j++)
            {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

                if(map.size() <= 2)
                {
                    count++;
                    maxCount = Math.max(maxCount, count);
                }
                else
                {
                    break;
                }
            }
        }
        return maxCount;
    }
}
