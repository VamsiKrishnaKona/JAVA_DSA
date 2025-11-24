package arrays.medium.NextPermutation;

import java.util.Arrays;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 9, 3, 5, 0, 0}; //output : {1, 2, 3};

        int[] ans = nextPermutation(nums);

        System.out.print(Arrays.toString(ans));
    }

    public static int[] nextPermutation(int[] nums)
    {
        int n = nums.length;

        int breakPoint = -1;

        for(int i = n - 2 ; i >= 0 ; i--)
        {
            if(nums[i] < nums[i + 1])
            {
                breakPoint = i;
                break;
            }
        }

        if(breakPoint == -1)
        {
            reverse(nums, 0, n - 1);
            return nums;
        }

        for(int i = n - 1 ; i > breakPoint ; i--)
        {
            if(nums[i] > nums[breakPoint])
            {
                int temp = nums[breakPoint];
                nums[breakPoint] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        reverse(nums, breakPoint + 1, n - 1);
        return nums;
    }

    public static void reverse(int[] nums, int start, int end)
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
}
