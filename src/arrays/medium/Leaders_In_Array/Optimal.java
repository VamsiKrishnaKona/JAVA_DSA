package arrays.medium.Leaders_In_Array;

import java.util.ArrayList;
import java.util.Collections;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{10, 22, 12, 3, 7, 0, 6};

        ArrayList<Integer> leaders = findLeaders(nums);

        System.out.println(leaders);
    }

    private static ArrayList<Integer> findLeaders(int[] nums)
    {
        int n = nums.length;
        ArrayList<Integer> leaders = new ArrayList<>();

        int currentMax = 0;

        for(int i = n - 1 ; i >= 0 ; i--)
        {
            if(nums[i] > currentMax)
            {
                currentMax = nums[i];
                leaders.add(nums[i]);
            }
        }

        Collections.reverse(leaders);

        return leaders;
    }
}
