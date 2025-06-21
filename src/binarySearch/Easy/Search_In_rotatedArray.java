package binarySearch.Easy;

public class Search_In_rotatedArray
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{7, 8, 9, 1, 2, 3, 4, 5, 6};
        int target = 8;

        int index = searchInRotatedArray(nums, target);

        System.out.println(index);
    }

    private static int searchInRotatedArray(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[low] <= nums[mid])
            {
                if(nums[low] <= target && target <= nums[mid])
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else
            {
                if(nums[mid] <= target && target <= nums[high])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
