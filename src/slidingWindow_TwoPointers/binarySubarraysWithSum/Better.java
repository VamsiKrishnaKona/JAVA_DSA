package slidingWindow_TwoPointers.binarySubarraysWithSum;

public class Better
{
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int target = 2;

        int count = findBinarySubArraysEqualsTarget(nums, target) -
                findBinarySubArraysEqualsTarget(nums, target - 1);
        System.out.print(count);
    }

    private static int  findBinarySubArraysEqualsTarget(int[] nums, int target)
    {
        if(target < 0) return 0;

        int n =  nums.length;
        int count = 0, sum = 0, l = 0, r = 0;

        while(r < n)
        {
            sum += nums[r];

            while(sum > target)
            {
                sum -= nums[l];
                l++;
            }

            count += (r - l + 1);
            r++;
        }

        return count;
    }
}

