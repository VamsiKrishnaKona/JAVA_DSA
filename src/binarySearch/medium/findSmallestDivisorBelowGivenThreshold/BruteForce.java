package binarySearch.medium.findSmallestDivisorBelowGivenThreshold;

public class BruteForce
{
    private static boolean possible(int[] nums, int threshold, int num)
    {
        int sum = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            sum += (nums[i] + num - 1) / num;
        }

        return sum <= threshold;
    }

    private static int findSmallestDivisor(int[] nums, int threshold)
    {
        for(int i = 1 ; i <= threshold ; i++)
        {
            boolean yes = possible(nums, threshold, i);

            if(yes)
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums = {8,4,2,3};
        int threshold = 10;

        int ans = findSmallestDivisor(nums, threshold);

        System.out.print(ans);
    }

    private static int max(int[] nums)
    {
        int max = Integer.MIN_VALUE;
        for(int i : nums)
        {
            max = Math.max(max, i);
        }

        return max;
    }
}
