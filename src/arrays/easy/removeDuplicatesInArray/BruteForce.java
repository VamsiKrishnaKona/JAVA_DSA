package arrays.easy.removeDuplicatesInArray;

import java.util.HashSet;

public class BruteForce
{
    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 7};
        removeDuplicates(nums);
    }

    private static void  removeDuplicates(int[] nums)
    {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
        {
            hs.add(nums[i]);
        }

        System.out.println(hs);
    }
}
