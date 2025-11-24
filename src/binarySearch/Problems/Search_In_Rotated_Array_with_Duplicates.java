package binarySearch.Problems;

public class Search_In_Rotated_Array_with_Duplicates
{
    public static void main(String[] args)
    {
        int[] nums = {4,5,6,7,7,7,0,1,2};
        int target = 7;

        System.out.println(search(nums, target));
    }

    private static int search(int[] nums, int target)
    {
        int pivot = findPivot(nums);

        if(pivot == -1)
            return binarySearch(nums, target, 0, nums.length - 1);

        if(nums[pivot] == target)
            return pivot;

        if(target >= nums[0])
        {
            return binarySearch(nums, target, 0, pivot - 1);
        }
        else
        {
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        }
    }

    private static int findPivot(int[] arr)
    {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(mid < end && arr[mid] > arr[mid + 1])
            {
                return mid;
            }

            if(mid > start && arr[mid] < arr[mid - 1])
            {
                return mid - 1;
            }

            if(arr[mid] == arr[start] && arr[mid] == arr[end])
            {
                if(arr[start] > arr[start + 1])
                {
                    return start;
                }
                start++;
                if(arr[end] < arr[end - 1])
                {
                    return end - 1;
                }
                end--;
            }
            else if(arr[start] <= arr[mid] || arr[start] == arr[mid] && arr[end] < arr[mid])
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }

        }
        return -1;
    }

    private static int binarySearch(int[] nums, int target, int start, int end)
    {
        if(nums.length == 0)
        {
            return -1;
        }

        while(start <= end)
        {
            int mid = start + (end - start)/2;

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
                return mid;
            }
        }

        return -1;
    }
}
