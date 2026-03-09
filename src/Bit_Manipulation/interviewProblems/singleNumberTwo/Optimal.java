package Bit_Manipulation.interviewProblems.singleNumberTwo;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = {5, 5, 5, 10, 4, 4, 4};
        int singleNumber = findSingleNumber(nums);
        System.out.println(singleNumber);
    }

    private static int findSingleNumber(int[] nums)
    {
        int ones = 0;
        int twos = 0;

        for(int i : nums)
        {
            ones ^= i & (~ twos);
            twos ^= i & (~ ones);
        }

        return ones;
    }
}
