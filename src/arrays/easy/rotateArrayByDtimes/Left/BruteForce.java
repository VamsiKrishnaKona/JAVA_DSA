package arrays.easy.rotateArrayByDtimes.Left;

import java.util.Arrays;

public class BruteForce
{
    private static int[] rotateArrayLeftByKtimes(int[] nums, int k)
    {
        int n = nums.length;

        if(n <= 1) return nums;

        k = k % n;

        int[] temp = new int[k];

        for(int i = n - k ; i < n ; i++)
        {
            temp[i - n + k] = nums[i];
        }

        for(int i = n - k - 1 ; i >= 0 ; i--)
        {
            nums[i + k] = nums[i];
        }

        for(int i = 0 ; i < k ; i++)
        {
            nums[i] = temp[i];
        }

        return nums;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        int[] ans = rotateArrayLeftByKtimes(nums, k);

        System.out.println(Arrays.toString(ans));

    }
}
