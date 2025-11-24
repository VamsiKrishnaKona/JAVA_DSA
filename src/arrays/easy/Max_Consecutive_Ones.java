package arrays.easy;

import static java.lang.Math.max;

public class Max_Consecutive_Ones
{
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1,1,0,1,1};

        int max = findMaxConsecutiveOnes(arr);

        System.out.println(max);
    }

    private static int findMaxConsecutiveOnes(int[] arr)
    {
        int max = 0;
        int count = 0;

        for(int i = 0 ; i < arr.length - 1 ; i++)
        {
            if(arr[i] == 1)
            {
                count++;
                max = max(max, count);
            }
            else
            {
                count = 0;
            }
        }
        return max;
    }
}
