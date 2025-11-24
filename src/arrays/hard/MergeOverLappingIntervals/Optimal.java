package arrays.hard.MergeOverLappingIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Optimal
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
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(ans.isEmpty() || nums[i][0] > ans.getLast().get(1))
            {
                ans.add(Arrays.asList(nums[i][0], nums[i][1]));
            }
            else
            {
                ans.getLast().set(1, Math.max(ans.getLast().get(1), nums[i][1]));
            }
        }
        return ans;
    }
}
