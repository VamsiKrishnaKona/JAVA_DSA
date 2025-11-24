package binarySearch.medium.findKthElementOfTwoSortedArrays;

public class BruteForce
{
    private static int findKthElement(int[] a, int[] b, int kth)
    {
        int i = 0, j = 0, k = 0;

        int[] nums = new int[a.length + b.length];

        while(i < a.length && j < b.length)
        {
            if(a[i] <= b[j])
            {
                nums[k] = a[i];
                k++;
                i++;
            }
            else
            {
                nums[k] = b[j];
                k++;
                j++;
            }
        }

        while(i < a.length)
        {
            nums[k] = a[i];
            k++;
            i++;
        }

        while(j < b.length)
        {
            nums[k] = b[j];
            k++;
            j++;
        }

        return nums[kth - 1];
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};

        int k = 4;

        int element = findKthElement(a, b, k);

        System.out.print(element);
    }
}
