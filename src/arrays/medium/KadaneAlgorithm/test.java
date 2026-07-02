package arrays.medium.KadaneAlgorithm;

public class test
{
    private static int[] printSubArray(int[] nums)
    {
        int n = nums.length;

        int maxSum = (int) -1e7;
        int sum = 0;

        int right = -1;
        int left = -1;

        for(int i = 0 ; i < n ; i++)
        {
            if(sum == 0) left = i;
            sum += nums[i];

            if(sum > maxSum)
            {
                maxSum = sum;
                right = i;
            }

            if(sum < 0) sum = 0;
        }

        return new int[] {left, right};
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{ -2, 1, -3, 4, -1, 2, 1, -5, 4};

        int[] indices = printSubArray(nums);

        for(int i = indices[0] ; i <= indices[1] ; i++)
        {
            System.out.print(nums[i] + " ");
        }
    }
}
