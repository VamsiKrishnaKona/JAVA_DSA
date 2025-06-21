package arrays.easy.rotateArrayByDtimes.Right;

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

    private static int[] rotateArrayRightByKtimes(int[] nums, int k)
    {
        int n = nums.length;

        if(n <= 1) return nums;

        k = k % n;

        int[] temp = new int[k];

        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);

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
