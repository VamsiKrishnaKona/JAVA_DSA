package arrays.hard.findMissingNumberAndRepeatingNumber;

<<<<<<< HEAD
=======
import java.util.Arrays;

>>>>>>> origin/krishna
public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{4, 3, 2, 1, 1, 6};

        findNums(nums);
    }

    private static void findNums(int[] nums)
    {
        long n = nums.length;

        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n+1) * (2*n+1)) / 6;

        int S = 0, S2 = 0;

        for(int i = 0 ; i < n ; i++)
        {
            S += nums[i];
            S2 += nums[i] * nums[i];
        }

        long val1 = S - SN;
        long val2 = S2 - S2N;
        val2 = val2 / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;




        System.out.print("Missing number : " + y + "\n");
        System.out.print("Repeating number : " + x);
    }
}
