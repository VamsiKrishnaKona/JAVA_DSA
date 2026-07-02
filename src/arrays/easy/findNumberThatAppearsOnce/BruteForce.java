package arrays.easy.findNumberThatAppearsOnce;

public class BruteForce
{
    public static void main(String [] args)
    {
        int[] nums = {1,1,2,2,3,4,4};

        System.out.println(findNumberThatAppearsOnce(nums));
    }

    // T.C = O(N ^ 2)
    // S.C = O(1)
    public static int findNumberThatAppearsOnce(int[] nums)
    {
        //Time complexity : O(n^2) because of 2 for loops
        for(int i = 0 ; i < nums.length ; i++)
        {
            int num = nums[i];
            int count = 0;
            for(int j = 0 ; j < nums.length ; j++)
            {
                if(nums[j] == num)
                {
                    count++;
                }
            }
            if(count == 1)
            {
                return num;
            }
        }
        return 0;
    }
}
