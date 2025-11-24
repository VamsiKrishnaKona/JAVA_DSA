package binarySearch.medium.MinimizeMaxDistanceBetweenGasStations;

public class Optimal_BinaryS1
{
    private static int noGasStationsRequired(int[] nums, double distance)
    {
        int count = 0;

        for(int i = 1 ; i < nums.length ; i++)
        {
            int placedInBetween = (int)((nums[i] - nums[i - 1]) / distance);

            if((nums[i] - nums[i - 1]) == placedInBetween * distance)
            {
                placedInBetween--;
            }

            count += placedInBetween;
        }
        return count;
    }

    private static double findMinimizedMax(int[] nums, int k)
    {
        double start = 0;
        double end = 0;

        for(int i = 1 ; i < nums.length ; i++)
        {
            end = Math.max(end, (double)(nums[i] - nums[i - 1]));
        }
        double precision = 1e-6;

        while((end - start) > precision)
        {
            double mid = (start + end) / (double)2;
            int count = noGasStationsRequired(nums, mid);

            if(count > k)
            {
                start = mid;
            }
            else
            {
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 5;

        double minimizedMaxDistance = findMinimizedMax(nums, k);

        System.out.print(minimizedMaxDistance);
    }
}
