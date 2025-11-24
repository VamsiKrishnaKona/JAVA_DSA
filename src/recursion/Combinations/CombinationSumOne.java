package recursion.Combinations;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumOne
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{2, 3, 6, 7};
        int k = 7;

        combinationSums(nums, k);
    }

    private static void combinationSums(int[] nums, int k)
    {
        int i = 0;
        List<Integer> sequence = new ArrayList<>();

        generateCombinations(nums, k, i, sequence);
    }

    private static void generateCombinations(int[] nums, int k, int i, List<Integer> sequence)
    {
        if(i >= nums.length || k == 0 )
        {
            if(k == 0)
            {
                System.out.println(sequence);
                return;
            }
            return;
        }

        if(nums[i] <= k)
        {
            sequence.add(nums[i]);
            generateCombinations(nums, k - nums[i], i + 1, sequence);
            sequence.removeLast();
        }
        generateCombinations(nums, k, i + 1, sequence);
    }
}
