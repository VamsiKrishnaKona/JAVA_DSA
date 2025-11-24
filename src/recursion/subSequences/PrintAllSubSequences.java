package recursion.subSequences;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubSequences
{
    //Print All Sub-Sequences
    public static void main(String[] args)
    {
        int[] nums = new int[]{3, 1, 2};

        printSubSequences(nums);
    }

    private static void printSubSequences(int[] nums)
    {
        List<Integer> subSequence = new ArrayList<>();

        int i = 0;
        int n = nums.length;

        generateSubSequence(nums, i, subSequence);
    }

    private static void generateSubSequence(int[] nums, int i, List<Integer> subSequence)
    {
        if(i >= nums.length)
        {
            System.out.println(subSequence);
            return;
        }

        subSequence.add(nums[i]);

        generateSubSequence(nums, i + 1, subSequence);

        //subSequence.remove(subSequence.size() - 1);
        subSequence.removeLast();

        generateSubSequence(nums, i + 1, subSequence);
    }
}
