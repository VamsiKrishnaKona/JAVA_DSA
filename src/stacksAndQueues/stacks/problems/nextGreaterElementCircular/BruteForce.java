package stacksAndQueues.stacks.problems.nextGreaterElementCircular;

import java.util.Arrays;

public class BruteForce
{
    public static void main(String[] args) {

        int[] nums = {2, 10, 12, 1, 11};

        int[] ans = findNextGreaterElements(nums);
        System.out.println(Arrays.toString(ans));
    }

    //T.C = o(n^2)
    //S.C = o(n)
    private static int[] findNextGreaterElements(int[] nums)
    {
        int[] nge = new int[nums.length];

        for(int i = 0 ; i < nums.length ; i++)
        {
            nge[i] = -1;
            for(int j = i + 1 ; j < nums.length ; j++)
            {
                if(nums[j] > nums[i])
                {
                    nge[i] = nums[j];
                    break;
                }
            }

            if(nge[i] == -1)
            {
                for(int k = 0 ; k < i ; k++)
                {
                    if(nums[k] > nums[i])
                    {
                        nge[i] = nums[k];
                        break;
                    }
                }
            }
        }

        return nge;
    }
}
