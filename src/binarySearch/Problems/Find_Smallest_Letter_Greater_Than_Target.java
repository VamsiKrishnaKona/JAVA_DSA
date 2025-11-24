package binarySearch.Problems;

public class Find_Smallest_Letter_Greater_Than_Target
{
    private static char ceilOfChars(char[] arr, char target)
    {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(target < arr[mid])
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return arr[start % arr.length];
    }

    public static void main(String [] args)
    {
        char[] arr = new char[]{'c', 'd', 'f', 'j'};
        char target = 'f';

        System.out.println(ceilOfChars(arr, target));
    }
}
