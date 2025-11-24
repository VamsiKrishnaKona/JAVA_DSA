package arrays.medium.KadaneAlgorithm;

public class PrintMaxSumSubArray
{
    private static void printSubArray(int[] nums)
    {
        int n = nums.length;

        int maxSum = 0;
        int sum = 0;

        int start = -1;
        int right = -1;
        int left = -1;

        for(int i = 0 ; i < n ; i++)
        {

            if(sum == 0)
                start = i;

            sum += nums[i];

            if(sum > maxSum)
            {
                maxSum = sum;
                right = start;
                left = i;
            }

            if(sum < 0)
                sum = 0;
        }

        System.out.print("[");
        for(int i = right ; i <= left ; i++)
        {
            System.out.print(nums[i] + " ");
        }
        System.out.print("]");

        System.out.print("\n" + maxSum);
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{ -2, 1, -3, 4, -1, 2, 1, -5, 4};

        printSubArray(nums);
    }
}
