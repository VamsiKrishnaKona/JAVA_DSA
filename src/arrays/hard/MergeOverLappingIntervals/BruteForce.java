package arrays.hard.MergeOverLappingIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BruteForce
{
    public static void main(String[] args)
    {
        int[][] nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};

        List<List<Integer>> intervals = findIntervals(nums);

        for(List<Integer> i : intervals)
        {
            System.out.print(i);
        }
    }

    private static List<List<Integer>> findIntervals(int[][] nums)
    {
        int n = nums.length;

        Arrays.sort(nums, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            int start = nums[i][0];
            int end = nums[i][1];

            if (!intervals.isEmpty() && end <= intervals.getLast().get(1))
            {
                continue;
            }

            for (int j = i + 1; j < n; j++)
            {
                if (nums[j][0] <= end)
                {
                    end = Math.max(end, nums[j][1]);
                } else
                {
                    break;
                }
            }
            intervals.add(Arrays.asList(start, end));
        }
        return intervals;
    }
}
