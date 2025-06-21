package arrays.hard.SubArrayCountEqualXOR_K;

public class BruteForce
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{4, 2, 2, 6, 4};
        int XOR = 6;

        int count = findSubArrayCount(nums, XOR);

        System.out.println(count);
    }

    private static int findSubArrayCount(int[] nums, int target)
    {
        int count = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            for(int j = i ; j < nums.length ; j++)
            {
                int xorr = 0;
                for(int k = i ; k <= j ; k++)
                {
                    xorr = xorr ^ nums[k];
                }

                if(xorr == target)
                    count++;
            }
        }

        return count;
    }
}
