package binarySearch;

public class OrderAgnosticBinarySearch
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{9,8,7,6,5};
        int target = 6;

        System.out.println(agnosticBS(arr, target));

    }

    private static int agnosticBS(int[] arr, int target)
    {
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while(start <= end)
        {
            int mid = start + (end - start)/2;

            if(isAsc)
            {
                if(target == arr[mid])
                {
                    return mid;
                }

                if(target > arr[mid])
                {
                    start = mid + 1;
                }
                else
                {
                    end = mid - 1;
                }
            }
            else
            {
                if(target == arr[mid])
                {
                    return mid;
                }

                if(target > arr[mid])
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
