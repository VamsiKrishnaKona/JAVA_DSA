package binarySearch.Problems;

//https://leetcode.com/problems/find-in-mountain-array/description/

public class SearchInMountainArray
{

    public static void main(String[] args)
    {
        int[] arr = new int[]{1,2,3,4,5,3,1};
        int target = 3;

        int ans = search(arr, target);

        System.out.println(ans);
    }

    static int search(int[] arr, int target)
    {
        int peak = peakIndex(arr);
        int firstTry = agnosticBS(arr,target,0,peak);

        if(firstTry != -1)
        {
            return firstTry;
        }
        return agnosticBS(arr,target,peak+1,arr.length - 1);
    }

    static int peakIndex(int[] arr)
    {
        int start = 0;
        int end = arr.length - 1;

        while(start < end)
        {
            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid + 1])
            {
                end = mid;
            }
            else
            {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int agnosticBS(int[] arr, int target, int start, int end)
    {
        boolean isAsc = arr[start] < arr[end];

        if(isAsc)
        {
            while(start <= end)
            {
                int mid = start + (end - start) / 2;

                if(target < arr[mid])
                {
                    end = mid - 1;
                }
                else if(target > arr[mid])
                {
                    start = mid + 1;
                }
                else
                {
                    return mid;
                }
            }
        }
        else
        {
            while(start <= end)
            {
                int mid = start + (end - start) / 2;

                if(target < arr[mid])
                {
                    start = mid + 1;

                }
                else if(target > arr[mid])
                {
                    end = mid - 1;
                }
                else
                {
                    return mid;
                }
            }
        }
        return -1;
    }
}
