package slidingWindow_TwoPointers.binarySubarraysWithSum;

public class BruteForce
{
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int target = 2;

        int count = findBinarySubArraysEqualsTarget(nums, target);
        System.out.print(count);
    }

    private static int  findBinarySubArraysEqualsTarget(int[] nums, int target)
    {
        int n =  nums.length;
        int count = 0;

        for(int i = 0 ; i < n ; i++)
        {
            int sum = 0;
            for(int j = i ; j < n ; j++)
            {
                sum += nums[j];
                if(sum == target)
                {
                    count++;
                }
            }
        }

        return count;
    }
}
