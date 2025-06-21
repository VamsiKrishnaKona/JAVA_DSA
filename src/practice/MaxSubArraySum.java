package practice;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 1, 3, 2};
        int k = 3;

        int maxSum = findMaxSum(nums, k);

        System.out.print(maxSum);
    }

    public static int findMaxSum(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k > n) return 0; // handle edge cases

        int maxSum = 0;

        // Calculate initial window sum
        int currentSum = 0;
        for (int i = 0; i < k; i++)
        {
            currentSum += nums[i];
        }
        maxSum = currentSum;
        int left = 0;
        // Slide the window
        for (int right = k; right < n; right++)
        {
            currentSum += nums[right] - nums[left];
            maxSum = Math.max(maxSum, currentSum);
            left++;
        }

        return maxSum;
    }
}