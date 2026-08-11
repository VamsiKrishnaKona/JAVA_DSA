package stacksAndQueues.stacks.problems.nextGreaterElement;

import java.util.Arrays;

public class BruteForce
{
    public static void main(String[] args)
    {
        int[] nums = {6, 0, 8, 1, 3};

        int[] nextGreaterElements = findNextGreaterElements(nums);

        System.out.println(Arrays.toString(nextGreaterElements));
    }

    // T.C = o(n^2)
    // S.C = o(n)
    private static int[] findNextGreaterElements(int[] nums)
    {
        int[] greaterElements = new int[nums.length];

        for(int i = 0 ; i < nums.length ; i++)
        {
            greaterElements[i] = -1;
            for(int j = i + 1 ; j < nums.length ; j++)
            {
                if(nums[j] > nums[i])
                {
                    greaterElements[i] = nums[j];
                    break;
                }
            }
        }

        return greaterElements;
    }
}
