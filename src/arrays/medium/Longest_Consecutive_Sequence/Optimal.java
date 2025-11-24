package arrays.medium.Longest_Consecutive_Sequence;

import java.util.HashSet;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = new int[] {0,3,7,2,5,8,4,6,0,1};

        int sequence = findLongestSequence(nums);

        System.out.println(sequence);
    }

    private static int findLongestSequence(int[] nums)
    {
        int n = nums.length;

        int longest = 1;

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums)
        {
            set.add(num);
        }

        for(int i = 0 ; i < n ; i++)
        {

            int element = nums[i];
            if(!set.contains(element - 1))
            {
                int count = 1;
                while(set.contains(element + 1))
                {
                    count += 1;
                    element = element + 1;
                }
                longest = Integer.max(longest, count);
            }
        }
        return longest;
    }

}
