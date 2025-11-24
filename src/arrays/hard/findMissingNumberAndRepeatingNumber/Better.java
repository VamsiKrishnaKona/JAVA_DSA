package arrays.hard.findMissingNumberAndRepeatingNumber;

import java.util.Arrays;

public class Better
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{4, 3, 2, 1, 1, 6, 7};
        int n = nums.length;

        findNums(nums);
    }

    private static void findNums(int[] nums)
    {

        int missing = -1;
        int repeating = -1;

        int[] hashArray = new int[nums.length + 1];
        Arrays.fill(hashArray, 0);

        for(int i : nums)
        {
            hashArray[i]++;
        }

        for(int i = 0 ; i < hashArray.length ; i++)
        {
            if(hashArray[i] == 0)
            {
                missing = i;
            }

            if(hashArray[i] > 1)
            {
                repeating = i;
            }
        }

        System.out.print("Missing number : " + missing + "\n");
        System.out.print("Repeating number : " + repeating);
    }
}
