package Bit_Manipulation.interviewProblems.singleNumberTwo;

public class Better
{
    public static void main(String[] args)
    {
        int[] nums = {5, 5, 5, 2, 4, 4, 4};
        int singleNumber = findSingleNumber(nums);
        System.out.println(singleNumber);
    }

    private static int findSingleNumber (int[] nums)
    {
        int singleNumber = 0;

        for(int i = 0 ; i <= 31 ; i++)
        {
            int count = 0;
            for(int j = 0 ; j < nums.length ; j++)
            {
                if((nums[j] & (1 << i)) != 0)
                {
                    count += 1;
                }
            }

            if(count % 3 == 1)
            {
                singleNumber |= (1 << i);
            }
        }

        return singleNumber;
    }
}
