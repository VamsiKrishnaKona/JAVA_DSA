package arrays.medium.KadaneAlgorithm;

public class Better
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        int sum = maximumSubArraySum(nums);

        System.out.println(sum);
    }

    private static int maximumSubArraySum(int[] nums)
    {
        int n = nums.length;
        int maxSum = 0;

        for(int i = 0 ; i < n ; i++)
        {
            int sum = 0;
            for(int j = i ; j < n ; j++)
            {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
