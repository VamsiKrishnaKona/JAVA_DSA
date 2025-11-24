package binarySearch.medium.findMedianOfTwoSortedArraysOfDiffrentSize;

public class BruteForce
{
    private static double findMedianInArrays(int[] nums1, int[] nums2)
    {
        int[] nums3 = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;

        int k = 0;

        while(i < nums1.length && j < nums2.length)
        {
            if(nums1[i] < nums2[j])
            {
                nums3[k] = nums1[i];
                i++;
                k++;
            }
            else
            {
                nums3[k] = nums2[j];
                k++;
                j++;
            }
        }

        while(i < nums1.length)
        {
            nums3[k] = nums1[i];
            k++;
            i++;
        }

        while(j < nums2.length)
        {
            nums3[k] = nums2[j];
            k++;
            j++;
        }

        int len = nums3.length;

        if(len % 2 != 0)
        {
            return nums3[len / 2];
        }

        return ((double)nums3[len / 2] + (double)nums3[(len / 2) - 1]) / 2.0;

    }

    public static void main(String[] args)
    {
        int[] nums1 = {1, 3, 4, 7, 10, 12};
        int[] nums2 = {2, 3, 6, 15};

        double median = findMedianInArrays(nums1, nums2);

        System.out.print(median);
    }
}
