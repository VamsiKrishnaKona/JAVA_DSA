package binarySearch.medium.findMissingKthInteger;

public class Optimal
{
    private static int findKthMissing(int[] nums, int K)
    {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            int missing = nums[mid] - (mid + 1);

            if(missing < K)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        // required = K - missing  // 5 - 3 = 2
        // which is K - (nums[high] - high + 1);
        // missing number will be nums[end] + required 7 + 2 = 9
        //nums[end] + K - nums[end] + high + 1 // 7 + 5 - 7 + 3 + 1 = 9
        //nums[end] - nums[end] will eliminate and high + K + 1 remained
        //which is also low + K // 4 + 5 = 9
        return K + end + 1;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{2, 3, 4, 7, 11};
        int K = 5;

        int ans = findKthMissing(nums, K);

        System.out.println(ans);
    }
}
