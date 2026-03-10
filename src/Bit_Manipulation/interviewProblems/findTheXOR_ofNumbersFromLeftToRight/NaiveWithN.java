package Bit_Manipulation.interviewProblems.findTheXOR_ofNumbersFromLeftToRight;

public class NaiveWithN
{
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ,13, 14, 15};
        int xor = findXOR(nums);
        System.out.println(xor);
    }

    //T.C : o(n)
    //S.C : o(1)
    private static int findXOR(int[] nums)
    {
        int xor = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            xor ^= nums[i];
        }

        return xor;
    }
}
