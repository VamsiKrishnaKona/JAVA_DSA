package arrays.easy.rotateArrayByDtimes.Left;

import java.util.Arrays;

public class Optimal
{
    private static void reverse(int[] nums, int start, int end)
    {
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private static int[] rotateArrayLeftByKtimes(int[] nums, int k)
    {
        int n = nums.length;

        if(n <= 1) return nums;

        k = k % n;

        reverse(nums, n - k, n - 1);
        reverse(nums, 0,n - k - 1);
        reverse(nums, 0, n - 1);

        return nums;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int k = 2;

        int[] ans = rotateArrayLeftByKtimes(nums, k);

        System.out.println(Arrays.toString(ans));

    }
}
