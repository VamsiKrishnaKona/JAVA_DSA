package arrays.hard.ReversePairs;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{40, 25, 19, 12, 9, 6, 2};

        int count = findReversePairs(nums);

        System.out.println(count);
    }

    private static int findReversePairs(int[] nums)
    {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int low, int high)
    {
        int count = 0;

        if(low == high) return count;

        int mid = low + (high - low) / 2;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countReversePairs(nums, low, mid, high);
        merge(nums, low, mid, high);

        return count;
    }

    private static void merge(int[] nums, int low, int mid, int high)
    {
        int[] temp = new int[high - low + 1];
        int tempIndex = 0;

        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high)
        {
            if(nums[left] <= nums[right])
            {
                temp[tempIndex] = nums[left];
                left++;
                tempIndex++;
            }
            else
            {
                temp[tempIndex] = nums[right];
                right++;
                tempIndex++;
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
    }

    private static int countReversePairs(int[] nums, int low, int mid, int high)
    {
        int count = 0;

        int right = mid + 1;

        for(int left = low ; left <= mid ; left++)
        {
            while(right <= high && nums[left] > 2L * nums[right] ) right++;
            count += (right - (mid + 1));
        }
        return count;
    }
}
