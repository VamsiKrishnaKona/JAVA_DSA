package arrays.easy.removeDuplicatesInArray;

import java.util.HashSet;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 7};
        removeDuplicates(nums);
    }

    private static void  removeDuplicates(int[] nums)
    {
        int spot = 0;

        for(int i = 1 ; i < nums.length; i++)
        {
            if(nums[i] != nums[spot])
            {
                spot++;
                swap(i, spot, nums);
            }
        }
    }

    private static void swap(int i, int j, int[] nums)
    {}

}
