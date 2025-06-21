package arrays.hard.MergeSortedArraysWithoutExtraSpace;

import java.util.ArrayList;
import java.util.List;

public class BruteForce
{
    public static void main(String[] args)
    {
        int[] nums1 = new int[]{1, 4, 8, 10};
        int[] nums2 = new int[]{2, 3, 9};

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
        List<Integer> nums3 = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < nums1.length && j < nums2.length)
        {
            if(nums1[i] <= nums2[j])
            {
                nums3.add(nums1[i]);
                i++;
            }
            else
            {
                nums3.add(nums2[j]);
                j++;
            }
        }

        while(i < nums1.length)
        {
            nums3.add(nums1[i]);
            i++;
        }

        while(j < nums2.length)
        {
            nums3.add(nums2[j]);
            j++;
        }

        for(int k = 0 ; k < nums1.length + nums2.length  ; k++)
        {
            if(k < nums1.length)
            {
                nums1[k] = nums3.get(k);
            }
            else
            {
                nums2[k - nums1.length] = nums3.get(k);

            }
        }
    }
}
