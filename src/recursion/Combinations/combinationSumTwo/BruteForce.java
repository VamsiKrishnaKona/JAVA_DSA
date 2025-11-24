package recursion.Combinations.combinationSumTwo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BruteForce
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 1, 1, 2, 2};
        int k = 4;

        List<List<Integer>> combinations = combinationSums(nums, k);

        System.out.println(combinations);
    }

    private static List<List<Integer>> combinationSums(int[] nums, int k)
    {
        int i = 0;
        List<Integer> sequence = new ArrayList<>();
        Set<List<Integer>> combinations = new HashSet<>();
        generateCombinations(nums, k, i, sequence, combinations);

        return combinations.stream().toList();
    }

    private static void generateCombinations(int[] nums, int k, int i, List<Integer> sequence, Set<List<Integer>> combinations)
    {
        if(i == nums.length)
        {
            if(k == 0)
            {
                combinations.add(new ArrayList<>(sequence));
            }
            return;
        }

        if(nums[i] <= k)
        {
            sequence.add(nums[i]);
            generateCombinations(nums, k - nums[i], i + 1, sequence, combinations);
            sequence.removeLast();
        }
        generateCombinations(nums, k, i + 1, sequence, combinations);
    }
}
