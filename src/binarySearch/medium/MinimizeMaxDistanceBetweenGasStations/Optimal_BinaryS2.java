package binarySearch.medium.MinimizeMaxDistanceBetweenGasStations;

public class Optimal_BinaryS2
{
    private static boolean stationsPlaced(int[] nums, int k, double distance)
    {
         int count = 0;

         for(int i = 1 ; i < nums.length ; i++)
         {
             int diff = nums[i] - nums[i - 1];

             count += (int) (diff/distance);
         }

         return count <= k;
    }

    private static double findMinimizedMax(int[] nums, int k)
    {
        double start = 0;
        double end = nums[nums.length - 1] - nums[0];

        double ans = 0;

        while(start <= end)
        {
            double mid = (start + end) / 2;

            if(stationsPlaced(nums, k, mid))
            {
                ans = mid;
                end = mid - 0.000001;
            }
            else
            {
                start = mid + 0.000001;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 5;

        double minimizedMaxDistance = findMinimizedMax(nums, k);

        System.out.print(minimizedMaxDistance);
    }
}
