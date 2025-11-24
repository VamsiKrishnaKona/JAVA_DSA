package recursion.Subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubsetOne
{
    public static void main(String [] args)
    {
        int[] nums = new int[]{1, 2, 3};

        List<List<Integer>> subsets = new ArrayList<>();

        subsets = generateSubsets(nums, subsets);

        System.out.print(subsets);
    }

    private static List<List<Integer>> generateSubsets(int[] nums, List<List<Integer>> subsets)
    {
        int i = 0;
        List<Integer> subset = new ArrayList<>();

        printSubsets(nums, subsets, subset, i);
        //Collections.sort(subsets, (a, b) -> Integer.compare(a.size(), b.size()));

        return subsets;
    }

    private static void printSubsets(int[] nums, List<List<Integer>> subsets, List<Integer> subset, int idx)
    {
        if(idx >= nums.length)
        {
            subsets.add(new ArrayList(subset));
            return;
        }

        subset.add(nums[idx]);

        printSubsets(nums, subsets, subset, idx + 1);

        subset.remove(subset.size() - 1);

        printSubsets(nums, subsets, subset, idx + 1);
    }
}
