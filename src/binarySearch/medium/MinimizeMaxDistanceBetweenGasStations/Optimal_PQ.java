package binarySearch.medium.MinimizeMaxDistanceBetweenGasStations;


import java.util.PriorityQueue;

public class Optimal_PQ
{
    private static double findMinimizedMax(int[] nums, int k)
    {
        int[] placed = new int[nums.length - 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

        for(int i = 0 ; i < nums.length - 1 ; i++)
        {
            pq.add(new Pair(nums[i + 1] - nums[i], i));
        }

        for(int gs = 1 ; gs <= k ; gs++)
        {
            Pair top = pq.poll();
            int sectionLen = top.second;

            placed[sectionLen]++;

            double initialDiff = nums[sectionLen + 1] - nums[sectionLen];
            double newSectionLen = initialDiff / (double) (placed[sectionLen] + 1) ;

            pq.add(new Pair(newSectionLen, sectionLen));
        }

        return pq.peek().first;

    }

    public static void main(String[] args)
    {
        int[] nums = {1, 13, 17, 23};
        int k = 5;

        double minimizedMaxDistance = findMinimizedMax(nums, k);

        System.out.print(minimizedMaxDistance);
    }
}
