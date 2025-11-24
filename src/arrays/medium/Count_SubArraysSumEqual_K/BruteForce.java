package arrays.medium.Count_SubArraysSumEqual_K;

public class BruteForce
{
    private static int checkSubArrayCount(int[] nums, int target)
    {
        int n = nums.length;

        int count = 0;

        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i ; j < n ; j++)
            {
                int sum = 0;
                for(int k = i ; k <= j ; k++)
                {
                    sum += nums[k];
                }
                if(sum == target)
                {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{3, 1, 2, 4};
        int k = 6;

        int count = checkSubArrayCount(nums, k);

        System.out.println(count);
    }
}
