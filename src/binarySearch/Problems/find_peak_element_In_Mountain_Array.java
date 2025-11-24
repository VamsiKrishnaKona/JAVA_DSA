package binarySearch.Problems;

public class find_peak_element_In_Mountain_Array
{
    private static int findPeak(int[] arr)
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

    public static void main(String[] args)
    {
        int[] arr = new int[]{1,2,3,5,7,6,3,2};

        int index = findPeak(arr);

        System.out.println(index);
    }
}
