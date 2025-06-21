package binarySearch.Easy;

public class Find_Minimum_In_RotatedSortedArray
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{6, 7, 1, 2, 3, 4, 5};

        int minimum = findMinimum(nums);

        System.out.println(minimum);
    }

    private static int findMinimum(int[] nums)
    {
        int min = Integer.MAX_VALUE;

        int low = 0;
        int high = nums.length - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(nums[low] <= nums[mid])
            {
                min = Math.min(min, nums[low]);
                low = mid + 1;
            }
            else
            {
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }

}
