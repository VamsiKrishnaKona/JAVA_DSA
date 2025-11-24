package binarySearch.medium.bookAllocation;

public class BruteForce
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
        int maxPages = sum(nums);

        for(int i = minPages ; i <= minPages*2 ; i++)
        {
            if(possible(nums, students, i))
            {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args)
    {
        int[] nums = new int[]{25, 46, 28, 49, 24};
        int students = 4;

        int minOfMaxPages = findMinOfMaxPages(nums, students);

        System.out.print(minOfMaxPages);
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
