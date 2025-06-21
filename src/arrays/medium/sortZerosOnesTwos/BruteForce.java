package arrays.medium.sortZerosOnesTwos;

import java.util.Arrays;

public class BruteForce
{
    private static void sort(int[] nums)
    {
        Arrays.sort(nums);
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{2,0,2,1,1,0};

        sort(nums);

        for(int i : nums)
        {
            System.out.print(i + " ");
        }
    }
}
