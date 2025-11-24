package binarySearch.medium.MinimizeMaxDistanceBetweenGasStations;

public class BruteForce
{
    private static int findMinimizedMax(int[] nums, int k)
    {
        int[] placed = new int[nums.length - 1];

        for(int gs = 1 ; gs <= k ; gs++)
        {
            int maxSection = -1;
            int maxIndex = -1;

            for(int i = 0 ; i < nums.length - 1 ; i++)
            {
                int diff = nums[i + 1] - nums[i];
                int sectionLength = diff / (placed[i] + 1);

                if(sectionLength > maxSection)
                {
                    maxSection = sectionLength;
                    maxIndex = i;
                }
            }
            placed[maxIndex]++;
        }

        int maxAns = -1;

        for(int i = 0 ; i < nums.length - 1 ; i++)
        {
            int diff = nums[i + 1] - nums[i];
            int sectionLength = diff / (placed[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }

        return maxAns;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 13, 17, 23};
        int k = 5;

        int minimizedMaxDistance = findMinimizedMax(nums, k);

        System.out.print(minimizedMaxDistance);
    }
}
