package recursion.subSequences;

import java.util.ArrayList;
import java.util.List;

public class PrintAnySubSequenceEqualsK
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 1};
        int k = 2;

        printSubSequences(nums, k);
    }

    private static void printSubSequences(int[] nums, int k)
    {
        List<Integer> subSequence = new ArrayList<>();

        int i = 0;
        int sum = 0;

        generateSubSequence(nums, i, sum, k, subSequence);
    }

    private static boolean generateSubSequence(int[] nums, int i, int sum, int k, List<Integer> subSequence)
    {
        if(i >= nums.length)
        {
            if(sum == k)
            {
                System.out.println(subSequence);
                return true;
            }

            return false;
        }

        sum += nums[i];
        subSequence.add(nums[i]);

        if(generateSubSequence(nums, i + 1, sum, k, subSequence))
        {
            return true;
        }

        //subSequence.remove(subSequence.size() - 1);
        subSequence.removeLast();
        sum -= nums[i];

        if(generateSubSequence(nums, i + 1, sum, k, subSequence))
        {
            return true;
        }

        return false;
    }
}
