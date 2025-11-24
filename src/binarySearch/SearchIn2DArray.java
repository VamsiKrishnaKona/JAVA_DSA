package binarySearch;

import java.util.Arrays;

public class SearchIn2DArray
{
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };

<<<<<<< HEAD
        int target = 50;
=======
        int target = 37;
>>>>>>> origin/krishna

        System.out.println(Arrays.toString(search(arr,target)));

    }

    static int[] search(int[][] matrix, int target)
    {
        int r = 0;
<<<<<<< HEAD
        int c = matrix[0].length - 1;

        while(r <= matrix.length - 1 && c >= 0)
=======
        int c = matrix.length - 1;

        while(r < matrix.length - 1 && c >= 0)
>>>>>>> origin/krishna
        {
            if(matrix[r][c] == target)
            {
                return new int[]{r, c};
            }

            if(matrix[r][c] < target)
            {
                r++;
            }
            else
            {
                c--;
            }
        }
        return new int[]{-1, -1};
    }
}
