package DP.LIS.longest_IncreasingSubSeqLen.wayOne;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = {10,9,2,5,3,7,101,18};
        int len = lengthOfLIS(nums);
        System.out.println(len);
    }

    private static int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        int[] ahead = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[n + 1];
            for (int prev = i - 1; prev >= -1; prev--) {
                int len = ahead[prev + 1];

                if (prev == -1 || nums[i] > nums[prev]) {
                    len = Math.max(1 + ahead[i + 1], len);
                }

                curr[prev + 1] = len;
            }
            ahead = curr;
        }
        return ahead[0];
    }
}
