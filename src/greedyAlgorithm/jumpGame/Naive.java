package greedyAlgorithm.jumpGame;

public class Naive
{
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 4, 1, 1, 1, 2};
        boolean reached = jumpGame(nums);
        System.out.print(reached);
    }

    private static boolean jumpGame(int[] nums)
    {
        int n = nums.length;
        int maxIdx = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if(i > maxIdx) return false;
            maxIdx = Math.max(maxIdx, i + nums[i]);
        }
        return true;
    }
}
