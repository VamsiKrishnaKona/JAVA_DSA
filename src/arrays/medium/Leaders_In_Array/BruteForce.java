package arrays.medium.Leaders_In_Array;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteForce
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{10, 22, 12, 3, 0, 6};

        ArrayList<Integer> leaders = findLeaders(nums);

        System.out.println(leaders);
    }

    private static ArrayList<Integer> findLeaders(int[] nums)
    {
        int n = nums.length;
        ArrayList<Integer> leaders = new ArrayList<>();

        for(int i = 0 ; i < n ; i++)
        {
            boolean yes = true;
            for(int j = i + 1 ; j < n ; j++)
            {
                if(nums[j] > nums[i])
                {
                    yes = false;
                    break;
                }
            }

            if(yes)
            {
                leaders.add(nums[i]);
            }
        }
        return leaders;
    }
}
