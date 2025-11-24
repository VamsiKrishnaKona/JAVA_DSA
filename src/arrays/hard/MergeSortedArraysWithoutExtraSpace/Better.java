package arrays.hard.MergeSortedArraysWithoutExtraSpace;

import java.util.Arrays;

public class Better
{
    public static void main(String[] args)
    {
        int[] nums1 = new int[]{1, 4, 8, 10};
        int[] nums2 = new int[]{2, 3, 5, 9};

        merge(nums1, nums2);

        for(int i : nums1)
        {
            System.out.print(i + " ");
        }

        System.out.println();

        for(int i : nums2)
        {
            System.out.print(i + " ");
        }
    }

    private static void merge(int[] nums1, int[] nums2)
    {
        int i = nums1.length - 1;
        int j = 0;

        while(i >= 0 && j <= nums2.length - 1)
        {
            if(nums1[i] > nums2[j])
            {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i--;
                j++;
            }
            else
            {
                break;
            }
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }
}
