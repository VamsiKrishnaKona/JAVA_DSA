package recursion.Permutations.PrintAllPermutations;

import java.util.*;
import java.util.stream.Collectors;

public class Optimal
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
        int i = 0;
        generatePermutations(i, nums, permutations);
    }

    private static void generatePermutations(int i, int[] nums, List<List<Integer>> permutations)
    {
        if(i >= nums.length)
        {
            List<Integer> subset = new ArrayList<>();

            for(int num : nums)
            {
                subset.add(num);
            }
            permutations.add(new ArrayList<>(subset));

            return;
        }

        for(int idx = i ; idx < nums.length ; idx++)
        {
            swap(i, idx, nums);
            generatePermutations(i + 1, nums, permutations);
            swap(i, idx, nums);
        }
    }

    private static void swap(int n1, int n2, int[] nums)
    {
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }
}
