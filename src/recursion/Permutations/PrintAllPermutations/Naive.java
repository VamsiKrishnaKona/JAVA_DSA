package recursion.Permutations.PrintAllPermutations;

import java.util.*;

public class Naive
{
    public static void main(String [] args)
    {
        int[] nums = new int[] { 1, 2, 3 };

        List<List<Integer>> permutations = new ArrayList<>();

        printAllPermutations(nums, permutations);

        System.out.print(permutations);
    }

    public static void printAllPermutations(int[] nums, List<List<Integer>> permutations)
    {
        List<Integer> subset = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();

        for(int num : nums)
        {
            map.put(num, false);
        }

        GeneratePermutations(subset, nums, map, permutations);
    }

    public static void GeneratePermutations(List<Integer> subset, int[] nums, Map<Integer, Boolean> map, List<List<Integer>> permutations)
    {
        if(subset.size() == nums.length)
        {
            permutations.add(new ArrayList<>(subset));
            return;
        }

        for(int idx = 0; idx < nums.length; idx++)
        {
            if(map.get(nums[idx]) == true) continue;

            subset.add(nums[idx]);
            map.put(nums[idx], true);

            GeneratePermutations(subset, nums, map, permutations);

            subset.remove(subset.size() - 1);
            map.put(nums[idx], false);
        }
    }
}
