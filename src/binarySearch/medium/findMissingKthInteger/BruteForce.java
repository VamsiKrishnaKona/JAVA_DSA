package binarySearch.medium.findMissingKthInteger;

public class BruteForce
{
    private static int findKthMissing(int[] nums, int K)
    {
        /* nums[i] = 2 which is less than K // K++ // K = 6
        // nums[i] = 3 which is less than K // K++ // K = 7
        // nums[i] = 4 which is less than K // K++ // K = 8
        // nums[i] = 7 which is less than K // K++ // K = 9
        // nums[i] = 11 which is not less than K then break and return K which is missing */

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] < K)
            {
                K++;
            }
            else
            {
                break;
            }
        }
        return K;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{2, 3, 4, 7, 11};
        int K = 5;

        int ans = findKthMissing(nums, K);

        System.out.println(ans);
    }
}
