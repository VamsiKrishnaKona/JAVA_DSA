package arrays.hard.SubArrayCountEqualXOR_K;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintSubArraysEqualsXOR_K {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 2, 6, 4};
        int XOR = 6;

        List<List<Integer>> subArrays = printSubArrayCount(nums, XOR);

        for (List<Integer> subArray : subArrays) {
            System.out.println(subArray);
        }
    }

    private static List<List<Integer>> printSubArrayCount(int[] nums, int target) {
        List<List<Integer>> subArrays = new ArrayList<>();

        Map<Integer, List<Integer>> mp = new HashMap<>();

        int xorr = 0;

        for (int i = 0; i < nums.length; i++)
        {
            xorr = xorr ^ nums[i];

            if (xorr == target)
            {
                subArrays.add(subArrayToList(nums, 0, i));
            }

            int k = xorr ^ target;

            if(mp.containsKey(k))
            {
                for(int startIndex : mp.get(k))
                {
                    subArrays.add(subArrayToList(nums, startIndex + 1, i));
                }
            }

            mp.computeIfAbsent(xorr, key -> new ArrayList<>()).add(i);
        }

        return subArrays;
    }

    private static List<Integer> subArrayToList(int[] nums, int start, int end) {
        List<Integer> subArray = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            subArray.add(nums[i]);
        }
        return subArray;
    }
}