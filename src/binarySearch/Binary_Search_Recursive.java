package binarySearch;

public class Binary_Search_Recursive
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{5, 2, 3, 4, 1, 6};
        int target = 4;

        int index = binarySearch(nums, target, 0, nums.length - 1);

        System.out.println(index);
    }

    private static int binarySearch(int[] nums, int target, int low, int high)
    {
        if(nums == null || low > high) return -1;

        int mid = low + (high - low) / 2;
        if(nums[mid] == target)
        {
            return mid;
        }


        if(target < nums[mid])
        {
            return binarySearch(nums, target, low, mid - 1);
        }
        else{
            return binarySearch(nums, target, mid + 1, high);
        }
    }
}
