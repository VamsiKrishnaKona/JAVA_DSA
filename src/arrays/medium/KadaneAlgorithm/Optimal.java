package arrays.medium.KadaneAlgorithm;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{-2, -3, -7, -2, -10, -4};

        int sum = maximumSubArraySum(nums);

        System.out.println(sum);
    }

    private static int maximumSubArraySum(int[] nums)
    {
        int n = nums.length;
        int maxSum = (int) -1e7;
        int sum = 0;

        for(int i = 0 ; i < n ; i++)
        {
            sum += nums[i];

            maxSum = Math.max(maxSum, sum);

            if(sum < 0)
            {
                sum = 0;
            }

        }

        return maxSum;
    }
}
