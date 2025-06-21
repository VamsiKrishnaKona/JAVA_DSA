package binarySearch.medium.minimumDaysToMakeBouquet;

public class Optimal
{
    private static boolean possible(int[] nums, int M, int K, int day)
    {

        int count = 0;
        int bouquetDone = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] <= day)
            {
                count += 1;

                //if(count == K) bouquetDone += count / K;
            }
            else
            {
                bouquetDone += count / K;
                count = 0;
            }
        }
        bouquetDone += count / K;

        return bouquetDone >= M;
    }

    private static int roseGarden(int[] nums, int M, int K)
    {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++)
        {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int start = min;
        int end = max;

        int done = -1;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(possible(nums, M, K, mid))
            {
                done = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }

        return done;
    }

    public static void main(String[] args) {
        int[] daysToBloom = {7, 7, 7, 7, 7, 7, 13, 11, 12, 7};
        int noOfBouquet = 2;
        int noOfFlowerToUse = 3;

        int ans = roseGarden(daysToBloom, noOfBouquet, noOfFlowerToUse);

        System.out.print(ans);
    }
}
