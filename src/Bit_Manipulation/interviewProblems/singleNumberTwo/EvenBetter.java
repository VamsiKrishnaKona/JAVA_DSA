package Bit_Manipulation.interviewProblems.singleNumberTwo;

public class EvenBetter
{
    public static void main(String[] args)
    {
        int[] nums = {10, 5, 5, 5, 4, 4, 4};
        int singleNumber = findSingleNumber(nums);
        System.out.println(singleNumber);
    }

    private static int findSingleNumber (int[] nums)
    {
        for(int i = 1 ; i < nums.length ; i+=3)
        {
            if(nums[i - 1] != nums[i]) return nums[i - 1];
        }

        return nums[nums.length - 1];
    }
}
