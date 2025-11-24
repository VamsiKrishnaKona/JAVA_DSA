package arrays.medium.Count_SubArraysSumEqual_K;

public class Better
{
    private static int checkSubArrayCount(int[] nums, int target)
    {
        int n = nums.length;

        int count = 0;

        for(int i = 0 ; i < n ; i++)
        {
            int sum = 0;
            for(int j = i ; j < n ; j++)
            {
                sum += nums[j];

                if(sum == target)
                    count++;
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
