package arrays.medium.ArrangeElementBySign;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Arrays;
import java.util.Collections;
>>>>>>> origin/krishna

public class Optimal
{
    private static ArrayList<Integer> arrange(int[] nums)
    {
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>(n);

        for(int num : nums)
        {
            arr.add(0);
        }

        int pos = 0;
        int neg = 1;

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] < 0)
            {
                arr.set(neg, nums[i]);
                neg += 2;
            }
            else
            {
                arr.set(pos, nums[i]);
                pos += 2;
            }
        }
        return arr;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, -4, -5};

        ArrayList<Integer> arr = arrange(nums);

        System.out.println(arr);
    }
}
