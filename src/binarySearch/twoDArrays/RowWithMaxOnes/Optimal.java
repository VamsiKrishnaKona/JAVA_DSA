package binarySearch.twoDArrays.RowWithMaxOnes;

public class Optimal
{
    private static int lowerBound(int[] nums, int m, int x)
    {
        int low = 0;
        int high = m - 1;

        int ans = m;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(nums[mid] >= x)
            {
                high = mid - 1;
                ans = mid;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int findMaxRow(int[][] nums)
    {
        int n = nums.length;
        int m = nums[0].length;

        int max_count = 0;
        int index = -1;

        for(int i = 0 ; i < n ; i++)
        {
            int count_ones = m - lowerBound(nums[i], m, 1);
            if(count_ones > max_count)
            {
                max_count = count_ones;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args)
    {
        int[][] nums = new int[][]{
                {0,0,1,1,1},
                {0,0,0,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {0,1,1,1,1}
        };

        int maxRow = findMaxRow(nums);

        System.out.print(maxRow);
    }
}
