package arrays.hard.Count_Inversions_In_Array;

public class BruteForce
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{5, 3, 2, 4, 1}; //count == 8

        int count = findInversions(nums);

        System.out.println(count);
    }

    private static int findInversions(int[] nums)
    {
        int count = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            for(int j = i + 1 ; j < nums.length ; j++)
            {
                if(nums[i] > nums[j]) count++;
            }
        }

        return count;
    }
}
