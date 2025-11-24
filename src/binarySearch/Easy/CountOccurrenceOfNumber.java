package binarySearch.Easy;

public class CountOccurrenceOfNumber
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 8, 8, 8, 8, 10};
        int target = 8;

        int count = findCount(nums, target);

        System.out.println(count);
    }

    private static int findCount(int[] nums, int target)
    {
        boolean isFirst = true;

        int first = binarySearch(nums, target, true);
        int last = binarySearch(nums, target, false);

        return last - first + 1;
    }

    private static int binarySearch(int[] nums, int target, boolean isFirst)
    {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(target < nums[mid])
            {
                end = mid - 1;
            }
            else if(target > nums[mid])
            {
                start = mid + 1;
            }
            else
            {
                ans = mid;
                if(isFirst)
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}
