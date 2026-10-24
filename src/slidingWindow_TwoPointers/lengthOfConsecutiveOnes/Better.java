package slidingWindow_TwoPointers.lengthOfConsecutiveOnes;

public class Better
{
    public static void main(String[] args)
    {
        int[] nums = {0, 0, 0, 1, 1, 1, 0};
        int k = 0;

        int onesLen = findMaxConsecutiveOnesLength(nums, k);

        System.out.print(onesLen);
    }

    static public int findMaxConsecutiveOnesLength(int[] nums, int k)
    {
        int n = nums.length;
        int maxLen = 0;
        int zeroesCount = 0;
        int left = 0, right = 0;
        int len = 0;

        while(right < n)
        {
            if(nums[right] == 0)
            {
                zeroesCount = zeroesCount + 1;
                if(zeroesCount > k)
                {
                    while(left <= right && zeroesCount > k)
                    {
                        if(nums[left] == 0)
                        {
                            zeroesCount--;
                        }
                        left++;
                    }
                }
                else
                {
                    len = right - left + 1;
                }
            }
            else
            {
                len = right - left + 1;
            }

            maxLen = Math.max(maxLen, len);
            right++;
        }

        return maxLen;
    }
}
