package arrays.medium.Longest_Consecutive_Sequence;

import java.util.Arrays;

public class Better
{
    public static void main(String[] args)
    {
        int[] nums = new int[] {100, 100, 101, 101, 102, 103, 104, 104, 104, 1, 1, 3, 2, 4, 4, 4};

        int sequence = findLongestSequence(nums);

        System.out.println(sequence);
    }

    private static int findLongestSequence(int[] nums)
    {
        int n = nums.length;

        int longest = 1;
        int count = 1;

        Arrays.sort(nums);
        int element = nums[0];

        for(int i = 1 ; i < n ; i++)
        {
           if(nums[i] == element + 1)
           {
               count++;
               element = nums[i];
           }
           else if(nums[i] == element)
           {
               continue;
           }
           else
           {
               element = nums[i];
               count = 1;
           }
           longest = Integer.max(longest, count);
        }


        return longest;
    }
}
