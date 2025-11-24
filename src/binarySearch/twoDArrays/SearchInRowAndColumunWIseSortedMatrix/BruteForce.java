package binarySearch.twoDArrays.SearchInRowAndColumunWIseSortedMatrix;

import java.util.Arrays;

public class BruteForce
{
    //T.C = o(N * M)
    private static int[] findTargetInMatrix(int[][] matrix, int target)
    {
        int n = matrix.length;

        for(int i = 0 ; i < n ; i++)
        {
            int m = matrix[i].length;
            for(int j = 0 ; j < m ; j++)
            {
                if(matrix[i][j] == target) return new int[]{i, j};
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
        int target = 14;

        int[] ans = findTargetInMatrix(matrix, target);

        System.out.print(Arrays.toString(ans));
    }
}
