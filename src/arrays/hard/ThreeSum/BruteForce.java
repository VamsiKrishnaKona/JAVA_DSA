package arrays.hard.ThreeSum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BruteForce
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> triplets = findTriplet(arr);

        for(List<Integer> i : triplets)
        {
            System.out.println(i);
        }
    }

    private static List<List<Integer>> findTriplet(int[] nums)
    {
        Set<List<Integer>> tripletSet = new HashSet<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            for(int j = i + 1 ; j < nums.length ; j++)
            {
                for(int k = j + 1 ; k < nums.length ; k++)
                {
                    List<Integer> ans = new ArrayList<>();
                    if(nums[i] + nums[j] + nums[k] == 0)
                    {
                            ans.add(nums[i]);
                            ans.add(nums[j]);
                            ans.add(nums[k]);

                            ans.sort(null);
                            tripletSet.add(ans);
                    }

                }
            }
        }

        return new ArrayList<>(tripletSet);
    }
}
