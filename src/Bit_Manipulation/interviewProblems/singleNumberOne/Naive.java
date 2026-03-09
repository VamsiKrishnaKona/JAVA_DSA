package Bit_Manipulation.interviewProblems.singleNumberOne;

import java.util.HashMap;
import java.util.Map;

public class Naive
{
    public static void main(String[] args)
    {
        int[] nums = {1, 1, 2, 3, 3, 4, 4};
        int ans = findSingleNumber(nums);
        System.out.println(ans);
    }

    private static int findSingleNumber(int[] nums)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() == 1)
            {
                return entry.getKey();
            }
        }

        return -1;
    }
}
