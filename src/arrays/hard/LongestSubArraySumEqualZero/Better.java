package arrays.hard.LongestSubArraySumEqualZero;

import java.util.HashMap;
import java.util.Map;

public class Better
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{1, -1, 3, 2, -2, -8, 1, 7, 10, 23};

        int longest = findLongestSubArraySum(nums);

        System.out.println(longest);
    }

    private static int findLongestSubArraySum(int[] nums)
    {
        int longest = 0;
        int sum = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            sum += nums[i];

            if(sum == 0)
            {
                longest = Math.max(longest, i + 1);
            }
            else
            {
                if(mp.containsKey(sum))
                {
                    longest = Math.max(longest, i - mp.get(sum));
                }
                else
                {
                    mp.put(sum, i);
                }
            }
        }

        return longest;
    }
}
