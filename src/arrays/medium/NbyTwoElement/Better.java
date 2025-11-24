package arrays.medium.NbyTwoElement;

import java.util.HashMap;
import java.util.Map;

public class Better
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};

        int ans = nByTwo(nums);

        System.out.print(ans);
    }

    private static int nByTwo(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], value + 1);
        }

        for(Map.Entry<Integer, Integer> i : map.entrySet())
        {
            if(i.getValue() > nums.length / 2)
            {
                return i.getKey();
            }
        }
        return -1;
    }
}
