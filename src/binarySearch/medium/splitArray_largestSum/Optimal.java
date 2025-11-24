package binarySearch.medium.splitArray_largestSum;

public class Optimal
{
    private static boolean split(int[] nums, int k, int maxSum)
    {
        int splits = 1;
        int sum = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] + sum > maxSum)
            {
                splits += 1;
                sum = nums[i];
            }
            else
            {
                sum += nums[i];
            }
        }

        if(splits <= k) return true;

        return false;
    }

    private static int findMinOfMaxSum(int[] nums, int k)
    {
        int min = max(nums);
        int max = sum(nums);

        int start = min;
        int end = max;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(split(nums, k, mid))
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int k = 3;

        int minOfMaxSum = findMinOfMaxSum(nums, k);

        System.out.println(minOfMaxSum);
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

    private static int sum(int[] nums)
    {
        int sum = 0;

        for(int i : nums)
        {
            sum += i;
        }
        return sum;
    }
}
