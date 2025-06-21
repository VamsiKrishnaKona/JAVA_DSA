package arrays.hard.findMissingNumberAndRepeatingNumber;

//Time complexity : O(n^2);
//Space complexity : O(1);

public class BruteForce
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{4, 3, 2, 1, 1, 6, 7};
        int n = nums.length;

        findNums(nums);
    }

    private static void findNums(int[] nums)
    {
        int missing = -1;
        int repeating = -1;

        for(int i = 1 ; i <= nums.length ; i++)
        {
            int count = 0;
            for(int j = 0 ; j < nums.length ; j++)
            {
                if(nums[j] == i)
                    count++;
            }

            if(count > 1)
            {
                repeating = i;
            }

            if( count == 0)
            {
                missing = i;
            }


        }

        System.out.print("Missing number : " + missing + "\n");
        System.out.print("Repeating number : " + repeating);
    }
}
