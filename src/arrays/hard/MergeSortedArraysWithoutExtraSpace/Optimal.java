package arrays.hard.MergeSortedArraysWithoutExtraSpace;

public class Optimal
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
        int n = nums1.length;
        int m = nums2.length;

        int len = n + m;

        int gap = (len / 2) + (len % 2);

        while(gap > 0)
        {
            int left = 0;
            int right = left + gap;

            while(right < len)
            {
                //nums1 && nums2
                if(left < n && right >= n)
                {
                    swap(nums1, nums2, left, right - n);
                }
                else if(left >= n) //nums2 && nums2
                {
                    swap(nums2, nums2, left - n, right - n);
                }
                else //nums1 && nums1
                {
                    swap(nums1, nums1, left, right);
                }

                left++;
                right++;
            }

            if(gap == 1) break;

            gap = (gap / 2) + (gap % 2);
        }
    }

    private static void swap(int[] nums1, int[] nums2, int ind1, int ind2)
    {
        if(nums1[ind1] > nums2[ind2])
        {
            int temp = nums1[ind1];
            nums1[ind1] = nums2[ind2];
            nums2[ind2] = temp;
        }
    }
}
