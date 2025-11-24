package arrays.medium.ArrangeElementBySign;

import java.util.ArrayList;
import java.util.Arrays;

public class UnBalancedSignedInteger
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3, -4, -5, 6};

        arrange(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void arrange(int[] nums)
    {
        int n = nums.length;

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int num : nums)
        {
            if(num > 0)
            {
                pos.add(num);
            }
            else
            {
                neg.add(num);
            }
        }

        if(pos.size() < neg.size())
        {
            for(int i = 0 ; i < pos.size() ; i++)
            {
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }

            int index = pos.size() * 2;

            for(int i = pos.size() ; i < neg.size() ; i++)
            {
                nums[index] = neg.get(i);
                index++;
            }
        }
        else
        {
            for(int i = 0 ; i < neg.size() ; i++)
            {
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }

            int index = neg.size() * 2;

            for(int i = neg.size() ; i < pos.size() ; i++)
            {
                nums[index] = pos.get(i);
                index++;
            }
        }

    }
}
