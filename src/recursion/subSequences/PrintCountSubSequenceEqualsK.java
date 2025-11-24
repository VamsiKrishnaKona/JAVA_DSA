package recursion.subSequences;

import java.util.ArrayList;
import java.util.List;

public class PrintCountSubSequenceEqualsK
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

        int count = generateSubSequence(nums, i, sum, k, subSequence);
        System.out.println(count);
    }

    private static int generateSubSequence(int[] nums, int i, int sum, int k, List<Integer> subSequence)
    {
        if(i >= nums.length)
        {
            if(sum == k)
            {
                //System.out.println(subSequence);
                return 1;
            }
            return 0;
        }

        sum += nums[i];
        subSequence.add(nums[i]);

        int l = generateSubSequence(nums, i + 1, sum, k, subSequence);

        //subSequence.remove(subSequence.size() - 1);
        subSequence.removeLast();
        sum -= nums[i];

        int r = generateSubSequence(nums, i + 1, sum, k, subSequence);

        return l + r;
    }
}
