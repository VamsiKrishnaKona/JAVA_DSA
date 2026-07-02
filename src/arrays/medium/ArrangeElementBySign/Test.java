package arrays.medium.ArrangeElementBySign;

import java.util.Arrays;

public class Test
{
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, -4, -5, -6};

        int[] ans = rearrange(nums);

        System.out.println(Arrays.toString(ans));
    }

    private static int[] rearrange(int[] nums)
    {
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];
        int posIdx = 0;
        int negIdx = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] < 0)
            {
                neg[negIdx] = nums[i];
                negIdx++;
            }
            else
            {
                pos[posIdx] = nums[i];
                posIdx++;
            }
        }

        int[] arr = new int[nums.length];

        for(int i = 0; i < arr.length; i += 2)
        {
            arr[i] = pos[i / 2];
            arr[i + 1] =  neg[i / 2];
        }
        return arr;
    }
}
