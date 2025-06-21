package binarySearch.Easy;

public class UpperBound
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{3,5,8,15,19};
        int target = 19;

        int index = upperBound(nums, target);

        System.out.println(index);
    }

    private static int upperBound(int[] nums, int target)
    {
        int ans = nums.length;

        int low = 0;
        int high = nums.length - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(nums[mid] > target)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }
}
