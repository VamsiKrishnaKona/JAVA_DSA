package arrays.hard.fourSum;

import java.util.*;

public class Better
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 0;

        List<List<Integer>> fourlets = fourSum(nums, target);

        for(List<Integer> i : fourlets)
        {
            System.out.println(i);
        }
    }

    private static List<List<Integer>> fourSum(int[] nums, int target)
    {

        Set<List<Integer>> hashSet = new HashSet<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            for(int j = i + 1 ; j < nums.length ; j++)
            {
                Set<Integer> hs = new HashSet<>();
                for(int k = j + 1 ; k < nums.length ; k++)
                {
                    int rem = target -(nums[i] + nums[j] + nums[k]);

                    if(hs.contains(rem))
                    {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], rem);
                        Collections.sort(temp);
                        hashSet.add(temp);

                    }
                    hs.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(hashSet);

    }
}
