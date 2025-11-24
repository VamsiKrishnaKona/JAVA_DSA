package recursion.Combinations.combinationSumTwo;

import java.util.*;

public class Optimal
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
        Arrays.sort(nums);
        List<Integer> sequence = new ArrayList<>();
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(nums, k, i, sequence, combinations);

        return combinations;
    }

    private static void generateCombinations(int[] nums, int k, int i, List<Integer> sequence, List<List<Integer>> combinations)
    {
        if(i >= nums.length || k == 0)
        {
            if (k == 0)
            {
                combinations.add(new ArrayList<>(sequence));
                return;
            }
            return;
        }
        for(int idx = i; idx < nums.length ; idx++)
        {
            if(idx > i && nums[idx] == nums[idx - 1]) continue;
            if(nums[idx] > k) break;

            sequence.add(nums[idx]);
            generateCombinations(nums, k - nums[idx], idx + 1, sequence, combinations);
            sequence.remove(sequence.size() - 1);
        }

    }
}
