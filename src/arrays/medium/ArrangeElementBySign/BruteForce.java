package arrays.medium.ArrangeElementBySign;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteForce
{
    private static void arrange(int[] nums)
    {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i : nums)
        {
            if(i > 0)
            {
                pos.add(i);
            }
            else
            {
                neg.add(i);
            }
        }

        for(int i = 0 ; i < nums.length / 2 ; i++)
        {
            nums[2 * i] = pos.get(i);
            nums[2 * i + 1] = neg.get(i);
        }
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, -4, -5};

        arrange(nums);

        System.out.println(Arrays.toString(nums));
    }
}
