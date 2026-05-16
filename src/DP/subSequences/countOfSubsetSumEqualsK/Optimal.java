package DP.subSequences.countOfSubsetSumEqualsK;

public class Optimal
{
    public static void main(String[] args) {

        int[] nums = {0, 0, 1};
        int target = 1;

        int check = isSubsetPresentEqualsK(nums, target);

        System.out.println(check);
    }

    private static int isSubsetPresentEqualsK(int[] nums, int target)
    {
        int[] prev = new int[target + 1];
        prev[0] = 1;
        if(nums[0] <= target ) prev[nums[0]] = 1;

        for(int i = 1 ; i < nums.length ; i++)
        {
            int[] curr =  new int[target + 1];
            curr[0] = 1;
            for(int j = 1 ; j <= target ; j++)
            {
                int notTaken = prev[j];
                int taken = 0;
                if(nums[i] <= j)
                {
                    taken = prev[j - nums[i]];
                }

                curr[j] = notTaken + taken;
            }
            prev = curr;
        }

        return prev[target];
    }
}
