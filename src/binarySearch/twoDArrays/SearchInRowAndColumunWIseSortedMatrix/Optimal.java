package binarySearch.twoDArrays.SearchInRowAndColumunWIseSortedMatrix;

import java.util.Arrays;

public class Optimal
{
    private static int[] findTargetInMatrix(int[][] matrix, int target)
    {
        int n = matrix.length;

        int row = 0;
        int col = matrix[0].length - 1;

        while(row < n && col >= 0)
        {
            if(matrix[row][col] == target)
            {
                return new int[]{row, col};
            }
            else if(matrix[row][col] < target)
            {
                row++;
            }
            else
            {
                col--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args)
    {
        int[][] matrix = {
                {1, 4 , 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 30;

        int[] ans = findTargetInMatrix(matrix, target);

        System.out.print(Arrays.toString(ans));
    }
}
