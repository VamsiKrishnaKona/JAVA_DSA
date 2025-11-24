package recursion.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetTwo
{
    public static void main(String [] args)
    {
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = subsetsWithDup(nums);
        System.out.print(subsets);

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(0, nums, subset, subsets);

        return subsets;
    }

    public static void generateSubsets(int idx, int[] nums, List<Integer> subset, List<List<Integer>> subsets)
    {
        subsets.add(new ArrayList<>(subset));

        for(int i = idx ; i < nums.length ; i++)
        {
            if(i > idx && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            generateSubsets(i + 1, nums, subset, subsets);
            subset.removeLast();
        }
    }
}
