package binarySearch.medium.findMedianOfTwoSortedArraysOfDiffrentSize;

public class Better
{
    private static double findMedianInArrays(int[] nums1, int[] nums2)
    {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int len = n1 + n2;

        int ind1 = len / 2;
        int ind2 = ind1 - 1;

        int ele1 = -1, ele2 = -1;

        int count = 0;

        int i = 0, j = 0;

        while(i < n1 && j < n2)
        {
            if(nums1[i] < nums2[j]) {
                if (count == ind1) ele1 = nums1[i];
                if (count == ind2) ele2 = nums1[i];
                count++;
                i++;
            }
            else
            {
                if (count == ind1) ele1 = nums2[j];
                if (count == ind2) ele2 = nums2[j];
                count++;
                j++;
            }
        }

        while(i < n1)
        {
            if (count == ind1) ele1 = nums1[i];
            if (count == ind2) ele2 = nums1[i];
            count++;
            i++;
        }

        while(j < n2)
        {
            if (count == ind1) ele1 = nums2[j];
            if (count == ind2) ele2 = nums2[j];
            count++;
            j++;
        }

        if(len % 2 != 0)
        {
            return ele2;
        }

        return (double)(ele1 + ele2) / 2.0;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {1, 3, 4, 7, 10, 12};
        int[] nums2 = {2, 3, 6, 15};

        double median = findMedianInArrays(nums1, nums2);

        System.out.print(median);
    }
}
