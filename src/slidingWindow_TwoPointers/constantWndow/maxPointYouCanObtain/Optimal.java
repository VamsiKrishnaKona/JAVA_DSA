package slidingWindow_TwoPointers.constantWndow.maxPointYouCanObtain;

public class Optimal
{
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;

        int maxPoints = obtainMaxPoints(nums, k);
        System.out.print(maxPoints);
    }

    private static int obtainMaxPoints(int[] nums, int k)
    {
        int n = nums.length;

        int maxPoints;

        int leftPoints = 0;
        int rightPoints = 0;

        for(int i = 0 ; i < k ; i++) leftPoints += nums[i];
        maxPoints = leftPoints;

        int right = n - 1;

        for(int left = k - 1 ; left >= 0 ; left--)
        {
            leftPoints -= nums[left];
            rightPoints += nums[right];
            maxPoints = Math.max(maxPoints, leftPoints + rightPoints);
            right--;
        }

        return maxPoints;
    }
}
