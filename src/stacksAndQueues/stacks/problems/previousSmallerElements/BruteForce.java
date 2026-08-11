package stacksAndQueues.stacks.problems.previousSmallerElements;

import java.util.Arrays;

public class BruteForce
{
    public static void main(String[] args) {

        int[] nums = {4, 5, 2, 10, 8};

        int[] prevSmallerElements = findPrevSmallerElements(nums);
        System.out.println(Arrays.toString(prevSmallerElements));
    }

    private static int[]  findPrevSmallerElements(int[] nums)
    {
        int n = nums.length;
        int[] pse = new int[n];

        for(int i = 0 ; i < n ; i++)
        {
            pse[i] = -1;
            for(int j = i - 1 ; j >= 0 ; j--)
            {
                if(nums[j] < nums[i])
                {
                    pse[i] = nums[j];
                    break;
                }
            }
        }

        return pse;
    }
}
