package Bit_Manipulation.interviewProblems.singleNumberThree;

import java.util.HashMap;
import java.util.Map;

public class Naive
{
    public static void main(String[] args)
    {
        int[] nums = {2, 4, 2, 14, 3, 3, 7, 7};
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
