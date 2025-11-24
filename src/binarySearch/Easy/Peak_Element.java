package binarySearch.Easy;

public class Peak_Element
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3, 6, 5, 4};

        int peak = findPeakElement(nums);

        System.out.println(peak);
    }

    private static int findPeakElement(int[] nums)
    {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[mid -1] && nums[mid] > nums[mid + 1])
            {
                return nums[mid];
            }

            if(nums[mid] >= nums[mid - 1])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }
}
