package Bit_Manipulation.interviewProblems.singleNumberThree;

import java.util.List;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = {2, 4, 2, 14, 3, 3, 7, 7};

        List<Integer> ans = findSingleNumbers(nums);
        System.out.println(ans);
    }

    public static List<Integer> findSingleNumbers(int[] nums)
    {
        int xor = 0;

        for(int i : nums) xor ^= i;

        xor &= (xor - 1) ^ xor;

        int idx = -1;
        for(int i = 0 ; i <= 31 ; i++)
        {
            if((xor >> i) == 1) idx = i;
        }

        int b1 = 0;
        int b2 = 0;

        for(int i : nums)
        {
            if(((i >> idx) & 1) == 0)
            {
                b1 ^= i;
            }
            else
            {
                b2 ^= i;
            }
        }

        return List.of(b1, b2);
    }
}
