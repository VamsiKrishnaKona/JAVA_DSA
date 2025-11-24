package arrays.medium.Two_Sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Optimal
{
    private static ArrayList<Integer> twoSum(int[] nums, int target)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        while(left < right)
        {
            int sum = nums[left] + nums[right];
            if(sum == target)
            {
                ans.add(left);
                ans.add(right);
                return ans;
            }
            else if(sum < target)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{2, 5, 6, 8, 11};
        int target = 14;

        ArrayList<Integer> ans = twoSum(nums, target);

        System.out.print(ans);
    }
}
