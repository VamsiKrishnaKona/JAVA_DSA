package arrays.hard.Count_Inversions_In_Array;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{5, 3, 2, 4, 1}; //count == 8

        int count = findInversions(nums);

        System.out.println(count);
    }

    private static int findInversions(int[] nums)
    {
        int low = 0;
        int high = nums.length - 1;

        return mergeSort(nums, low, high);
    }

    private static int mergeSort(int[] nums, int low, int high)
    {
        int count = 0;
        if(low >= high)
            return count;

        int mid = low + (high - low) / 2;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += merge(nums, low, mid, high);

        return count;
    }

    private static int merge(int[] nums, int low, int mid, int high)
    {
        int count = 0;
        int[] temp = new int[nums.length];

        int left = low;
        int right = mid + 1;
        int tempIndex = 0;

        while(left <= mid && right <= high)
        {
            if(nums[left] <= nums[right])
            {
                temp[tempIndex] = nums[left];
                tempIndex++;
                left++;
            }
            else
            {
                temp[tempIndex] = nums[right];
                tempIndex++;
                right++;
                count += (mid - left + 1);
            }
        }

        while(left <= mid)
        {
            temp[tempIndex] = nums[left];
            tempIndex++;
            left++;
        }

        while(right <= high)
        {
            temp[tempIndex] = nums[right];
            tempIndex++;
            right++;
        }

        for(int i = low ; i <= high ; i++)
        {
            nums[i] = temp[i - low];
        }

        return count;
    }
}
