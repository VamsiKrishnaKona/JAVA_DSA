package binarySearch.medium.bookAllocation;

public class Optimal
{
    private static boolean possible(int[] nums, int students, int page)
    {
        int studentAlloc = 1;
        int pages = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(pages + nums[i] > page )
            {
                studentAlloc += 1;
                pages = nums[i];
            }
            else
            {
                pages += nums[i];
            }
        }

        if(studentAlloc <= 4) return true;

        return false;
    }

    private static int findMinOfMaxPages(int[] nums, int students)
    {
        int minPages = max(nums);

        int start = minPages;
        int end = sum(nums);

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(possible(nums, students, mid))
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return start;
    }


    public static void main(String[] args)
    {
        int[] nums = new int[]{25, 46, 28, 49, 24};
        int students = 4;

        int minOfMaxPages = findMinOfMaxPages(nums, students);

        System.out.println(minOfMaxPages);
    }

    private static int max(int[] nums)
    {
        int max = Integer.MIN_VALUE;

        for(int i : nums)
        {
            max = Math.max(max, i);
        }
        return max;
    }

    private static int sum(int[] nums)
    {
        int sum = 0;

        for(int i : nums)
        {
            sum += i;
        }
        return sum;
    }
}
