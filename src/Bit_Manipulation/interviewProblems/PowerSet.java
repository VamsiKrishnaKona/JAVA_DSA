package Bit_Manipulation.interviewProblems;

import java.util.ArrayList;
import java.util.List;

public class PowerSet
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3};

        List<List<Integer>> ans = generatePowerSet(nums);

        for(List<Integer> item : ans)
        {
            System.out.println(item);
        }
    }

    public static List<List<Integer>> generatePowerSet(int[] nums)
    {
        List<List<Integer>> powerSet = new ArrayList<>();
        for(int i = 0 ; i <= (1 << nums.length) - 1 ; i++)
        {
            List<Integer> subset = new ArrayList<>();
            for(int j = 0 ; j <= nums.length - 1 ; j++)
            {
                if((i & (1 << j)) != 0)
                {
                    subset.add(nums[j]);
                }
            }
            powerSet.add(subset);
        }

        return powerSet;
    }

}
