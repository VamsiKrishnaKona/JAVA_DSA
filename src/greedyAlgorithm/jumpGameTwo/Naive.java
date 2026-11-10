package greedyAlgorithm.jumpGameTwo;

public class Naive
{
    public static void main(String[] args) {

        int[] nums = {2, 3, 0, 1, 4};
        int minSteps = jumpGameTwo(0, nums);
        System.out.print(minSteps);
    }

    private static int jumpGameTwo(int i, int[] nums)
    {
        if(i == nums.length - 1) return 0;

        int minCount = (int) 1e+5;
        if(nums[i] == 0 || i > nums.length - 1) return minCount;

        for(int idx = 1 ; idx <= nums[i] ; idx++)
        {
            int steps = 1 + jumpGameTwo(i + idx, nums);
            minCount = Math.min(minCount, steps);
        }
        return minCount;
    }
}
