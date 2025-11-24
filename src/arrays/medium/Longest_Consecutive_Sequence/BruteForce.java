package arrays.medium.Longest_Consecutive_Sequence;

public class BruteForce
{
    public static void main(String[] args)
    {
        int[] nums = new int[] {100, 200, 1, 3, 2, 4};

        int sequence = findLongestSequence(nums);

        System.out.println(sequence);
    }

    private static int findLongestSequence(int[] nums)
    {
        int n = nums.length;

        int longest = 1;

        for(int i = 0 ; i < n ; i++)
        {
            int count = 1;
            int num = nums[i];
            for(int j = 0 ; j < n ; j++)
            {
                while(linearSearch(nums, num + 1))
                {
                    count += 1;
                    num += 1;
                }

            }
            longest = Integer.max(longest, count);
        }
        return longest;
    }

    private static boolean linearSearch(int[] nums, int num)
    {
        for(int i : nums)
        {
            if(i == num)
            {
                return true;
            }
        }
        return false;
    }
}
