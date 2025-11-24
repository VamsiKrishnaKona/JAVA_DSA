package arrays.hard.ThreeSum;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
=======
import java.util.*;
>>>>>>> origin/krishna

public class Better
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
        HashSet<List<Integer>> triplets = new HashSet<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            HashSet<Integer> numSet = new HashSet<>();

            for(int j = i + 1 ; j <= nums.length - 1 ; j++)
            {
                int n3 = - (nums[i] + nums[j]);

                if(numSet.contains(n3))
                {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], n3);

                    triplet.sort(null);

                    triplets.add(triplet);
                }

                numSet.add(nums[j]);

            }
        }
        return new ArrayList<>(triplets);
    }
}
