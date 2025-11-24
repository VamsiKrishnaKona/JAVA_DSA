package arrays.medium.Two_Sum;

import java.util.ArrayList;
import java.util.HashMap;

public class Better
{
    private static ArrayList<Integer> twoSum(int[] nums, int target)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            int rem = target - nums[i];

            if(map.containsKey(rem))
            {
                ans.add(map.get(rem));
                ans.add(i);
                return ans;
            }

            map.put(nums[i], i);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{2, 6, 5, 8, 11};
        int target = 12;

        ArrayList<Integer> ans = twoSum(nums, target);

        System.out.print(ans);
    }
}
