package arrays.easy.findMissingNumber;

public class BruteForce
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,4,5};
        System.out.println(findMissingNumber(arr));
    }

    static int findMissingNumber(int[] nums)
    {
        int n = nums.length;
        int sum1 = (n * (n + 1)) / 2;

        int sum2 = 0;
        for(int i = 0 ; i < n - 1 ; i++)
        {
            sum2 += nums[i];
        }
        return sum1 - sum2;
    }
}
