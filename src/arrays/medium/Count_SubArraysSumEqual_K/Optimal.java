package arrays.medium.Count_SubArraysSumEqual_K;

import java.util.HashMap;

public class Optimal
{
    private static int checkSubArrayCount(int[] nums, int target)
    {
        int n = nums.length;

        int count = 0;
        int sum = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        mp.put(0, 1);

        for(int i = 0 ; i < n ; i++)
        {
            sum += nums[i];

            int remove = sum - target;

            count += mp.getOrDefault(remove, 0);

            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{3, 1, 2, 4};
        int k = 6;

        int count = checkSubArrayCount(nums, k);

        System.out.println(count);
    }
}
