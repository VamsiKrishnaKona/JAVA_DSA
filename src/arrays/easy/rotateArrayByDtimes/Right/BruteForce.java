package arrays.easy.rotateArrayByDtimes.Right;

import java.util.Arrays;

public class BruteForce
{
    private static int[] rotateArrayRightByKtimes(int[] nums, int k)
    {
        int n = nums.length;

        if(n <= 1) return nums;

        k = k % n;

        int[] temp = new int[k];

        for(int i = 0 ; i < k ; i++)
        {
            temp[i] = nums[i];
        }

        for(int i = k ; i < n ; i++)
        {
            nums[i - k] = nums[i];
        }

        for(int i = n - k ; i < n ; i++)
        {
            nums[i] = temp[i - n + k];
        }

        return nums;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        int[] ans = rotateArrayRightByKtimes(nums, k);

        System.out.println(Arrays.toString(ans));

    }
}
