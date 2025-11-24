package binarySearch.medium.MinimizeMaxDistanceBetweenGasStations;

public class BruteForce
{
<<<<<<< HEAD
    private static double findMinimizedMax(int[] nums, int k)
=======
    private static int findMinimizedMax(int[] nums, int k)
>>>>>>> origin/krishna
    {
        int[] placed = new int[nums.length - 1];

        for(int gs = 1 ; gs <= k ; gs++)
        {
<<<<<<< HEAD
            double maxSection = -1;
=======
            int maxSection = -1;
>>>>>>> origin/krishna
            int maxIndex = -1;

            for(int i = 0 ; i < nums.length - 1 ; i++)
            {
<<<<<<< HEAD
                double diff = nums[i + 1] - nums[i];
                double sectionLength = diff / (double)(placed[i] + 1);
=======
                int diff = nums[i + 1] - nums[i];
                int sectionLength = diff / (placed[i] + 1);
>>>>>>> origin/krishna

                if(sectionLength > maxSection)
                {
                    maxSection = sectionLength;
                    maxIndex = i;
                }
            }
            placed[maxIndex]++;
        }

<<<<<<< HEAD
        double maxAns = -1;

        for(int i = 0 ; i < nums.length - 1 ; i++)
        {
            double diff = nums[i + 1] - nums[i];
            double sectionLength = diff / (double)(placed[i] + 1);
=======
        int maxAns = -1;

        for(int i = 0 ; i < nums.length - 1 ; i++)
        {
            int diff = nums[i + 1] - nums[i];
            int sectionLength = diff / (placed[i] + 1);
>>>>>>> origin/krishna
            maxAns = Math.max(maxAns, sectionLength);
        }

        return maxAns;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 13, 17, 23};
        int k = 5;

<<<<<<< HEAD
        double minimizedMaxDistance = findMinimizedMax(nums, k);
=======
        int minimizedMaxDistance = findMinimizedMax(nums, k);
>>>>>>> origin/krishna

        System.out.print(minimizedMaxDistance);
    }
}
