package linearSearch;

import java.util.Arrays;

public class Search_In_2D
{

    static int maxIn2D(int[][] arr)
    {
        int max = Integer.MIN_VALUE;

        for(int row = 0; row < arr.length ; row++)
        {
            for(int col = 0 ; col < arr[row].length ; col++)
            {
                if(arr[row][col] > max)
                {
                    max = arr[row][col];
                }
            }
        }
        return max;
    }

    ////////////////////////////////////////////////////////////////////////////////////
    static int[] search(int[][] arr, int target)
    {
        for(int row = 0 ; row < arr.length ; row++)
        {
            for(int col = 0 ; col < arr[row].length ; col++)
            {
                if(target == arr[row][col])
                {
                    return new int[]{row,col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args)
    {
        int[][] arr = {
                        {23, 4, 1},
                        {18, 12, 3, 9},
                        {78, 99}
        };

        int target = 12;

        System.out.println(Arrays.toString(search(arr,target)));

        System.out.println();
    }
}
