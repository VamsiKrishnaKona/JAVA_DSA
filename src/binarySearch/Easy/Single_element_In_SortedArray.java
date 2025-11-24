package binarySearch.Easy;

public class Single_element_In_SortedArray
{
    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};

        int num = findSingleElement(nums);

        System.out.println(num);
    }

    private static int findSingleElement(int[] nums)
    {
        int low = 0;
        int high = nums.length - 1;

        if(nums.length == 1) return nums[0];

        if(nums[0] != nums[1]) return nums[0];

        if(nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];

        low++;

        high--;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
            {
                return nums[mid];
            }

            if(mid % 2 == 1 && nums[mid - 1] == nums[mid] || mid % 2 == 0 && nums[mid + 1] == nums[mid])
            {
                low = mid + 1;
            }
            else//(mid % 2 == 1 && nums[mid + 1] == nums[mid] || mid % 2 == 0 && nums[mid - 1] == nums[mid]) checking we are right side
            {   // element must be on left side, though we eliminate right half.
                high = mid - 1;
            }
        }
        return -1;
    }
}
