package binarySearch.twoDArrays;

public class findMinimum_In_RotatedSortedArray_with_DUPs
{
    public static void main(String[] args)
    {
        int[] nums = {0, 1, 2, 2, 2,};

        System.out.println(search(nums));
    }

    static int search(int[] nums)
    {
        int min = findPivot(nums);

        if(min == -1) return nums[0];

        return nums[min + 1];
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
                if(start + 1 <= end && arr[start] > arr[start + 1])
                {
                    return start;
                }
                start++;
                if(end - 1 >= start && arr[end] < arr[end - 1])
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
}
