package arrays.hard.SubArrayCountEqualXOR_K;

import java.util.HashMap;
import java.util.Map;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{4, 2, 2, 6, 4};
        int XOR = 6;

        int count = findSubArrayCount(nums, XOR);

        System.out.println(count);
    }

    private static int findSubArrayCount(int[] nums, int target)
    {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int count = 0;
        int xr = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            xr ^= nums[i];

            if(mp.containsKey(xr ^ target))
            {
                count += mp.get(xr ^ target);
            }

            int value = mp.getOrDefault(xr, 0);
            mp.put(xr, value + 1);

        }
        return count;
    }
}
