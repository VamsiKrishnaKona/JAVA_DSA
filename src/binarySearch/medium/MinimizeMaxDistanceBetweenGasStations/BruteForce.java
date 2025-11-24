package binarySearch.medium.MinimizeMaxDistanceBetweenGasStations;

public class BruteForce
{
    private static double findMinimizedMax(int[] nums, int k)
    {
        int[] placed = new int[nums.length - 1];

        for(int gs = 1 ; gs <= k ; gs++)
        {
            double maxSection = -1;
            int maxIndex = -1;

            for(int i = 0 ; i < nums.length - 1 ; i++)
            {
                double diff = nums[i + 1] - nums[i];
                double sectionLength = diff / (double)(placed[i] + 1);

                if(sectionLength > maxSection)
                {
                    maxSection = sectionLength;
                    maxIndex = i;
                }
            }
            placed[maxIndex]++;
        }

        double maxAns = -1;

        for(int i = 0 ; i < nums.length - 1 ; i++)
        {
            double diff = nums[i + 1] - nums[i];
            double sectionLength = diff / (double)(placed[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }

        return maxAns;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 13, 17, 23};
        int k = 5;

        double minimizedMaxDistance = findMinimizedMax(nums, k);

        System.out.print(minimizedMaxDistance);
    }
}
