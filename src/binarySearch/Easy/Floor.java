package binarySearch.Easy;

public class Floor
{
    public static void main(String [] args)
    {
        int[] nums = new int[]{1, 3, 6, 7, 10, 11, 13, 15};
        int target = 14;

        int floor = findFloor(nums, target);

        System.out.println(floor);
    }

    private static int findFloor(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(target < nums[mid])
            {
                high = mid - 1;
            }
            else if(target > nums[mid])
            {
                low = mid + 1;
            }
            else
            {
                return nums[high];
            }
        }
        return nums[high];
    }
}
