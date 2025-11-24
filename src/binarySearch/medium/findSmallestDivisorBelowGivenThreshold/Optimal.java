package binarySearch.medium.findSmallestDivisorBelowGivenThreshold;

public class Optimal
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
        int smallestDiv = Integer.MAX_VALUE;

        int start = 1;
        int end = threshold;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(possible(nums, threshold, mid))
            {
                smallestDiv = Math.min(smallestDiv, mid);
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return smallestDiv;

    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        int ans = findSmallestDivisor(nums, threshold);

        System.out.print(ans);
    }
}
