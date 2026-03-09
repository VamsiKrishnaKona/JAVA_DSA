package Bit_Manipulation.interviewProblems.singleNumberOne;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = {1, 1, 2, 3, 3, 4, 4};
        int ans = findSingleNumber(nums);
        System.out.println(ans);
    }

    private static int findSingleNumber(int[] nums)
    {
        int xor = 0;

        for(int i : nums)
        {
            xor ^= i;
        }

        return xor;
    }
}
