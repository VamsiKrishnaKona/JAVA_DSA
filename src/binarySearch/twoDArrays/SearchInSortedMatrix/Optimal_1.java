package binarySearch.twoDArrays.SearchInSortedMatrix;

import java.util.Arrays;

public class Optimal_1
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
        int[][] matrix = new int[][]{
                {3, 4, 7, 9},
                {12, 13, 16, 18},
                {20, 21, 23, 29}
        };

        int target = 29;

        int[] ans = findTargetInMatrix(matrix, target);

        System.out.print(Arrays.toString(ans));
    }
}
