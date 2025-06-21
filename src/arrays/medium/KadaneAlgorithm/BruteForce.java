package arrays.medium.KadaneAlgorithm;

public class BruteForce
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
            for(int j = i ; j < n ; j++)
            {
                int sum = 0;
                for(int k = i ; k <= j ; k++)
                {
                    sum += nums[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
