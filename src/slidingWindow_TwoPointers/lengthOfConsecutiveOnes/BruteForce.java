package slidingWindow_TwoPointers.lengthOfConsecutiveOnes;

public class BruteForce
{
    public static void main(String[] args)
    {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        int onesLen = findMaxConsecutiveOnesLength(nums, k);

        System.out.print(onesLen);
    }

    static public int findMaxConsecutiveOnesLength(int[] nums, int k)
    {
        int n = nums.length;
        int maxLen = 0;

        for(int i = 0 ; i < n ; i++)
        {
            int zeroesCount = 0;
            for(int j = i ; j < n ; j++)
            {
                if(nums[j] == 0) zeroesCount++;

                if(zeroesCount <= k)
                {
                    int len = (j - i) + 1;
                    maxLen = Math.max(maxLen, len);
                }
                else
                {
                    break;
                }
            }
        }
        return maxLen;
    }
}
