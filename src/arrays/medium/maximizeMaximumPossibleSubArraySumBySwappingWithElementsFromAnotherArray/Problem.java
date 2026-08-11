package arrays.medium.maximizeMaximumPossibleSubArraySumBySwappingWithElementsFromAnotherArray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem
{
    public static void main(String[] args) {

        int[] b = {7, 2, -1, 4, 5};
        int[] a = {1, 2, 3, 2};

        int ans = maximizeTheSumBySwaps(a, b);

        System.out.println(ans);
    }

    private static int maximizeTheSumBySwaps(int[] nums1, int[] nums2)
    {
        List<Integer> list = new ArrayList<>();

        for(int num : nums1) list.add(num);
        for(int num : nums2) list.add(num);

        list.sort(Comparator.reverseOrder());

        int len = Math.max(nums1.length, nums2.length);
        int sum = 0;

        for(int i = 0 ; i < len ; i++)
        {
            sum += list.get(i);
        }
        return sum;
    }
}
