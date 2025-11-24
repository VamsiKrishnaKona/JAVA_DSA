package arrays.medium.Two_Sum;

import java.util.ArrayList;

public class BruteForce
{
    private static ArrayList<Integer> twoSum(int[] nums, int target)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            for(int j = i + 1 ; j < nums.length ; j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    ans.add(i);
                    ans.add(j);
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{2, 6, 5, 8, 11};
        int target = 14;

        ArrayList<Integer> ans = twoSum(nums, target);

        System.out.print(ans);
    }
}
