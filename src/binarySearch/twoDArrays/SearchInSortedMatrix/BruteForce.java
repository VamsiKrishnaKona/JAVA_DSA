package binarySearch.twoDArrays.SearchInSortedMatrix;

import java.util.Arrays;

public class BruteForce
{
    // t.c = o(n * log base2 of M)
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
        int[][] matrix = new int[][]{
                {3, 4, 7, 9},
                {12, 13, 16, 18},
                {20, 21, 23, 29}
        };

        int target = 21;

        int[] ans = findTargetInMatrix(matrix, target);

        System.out.print(Arrays.toString(ans));
    }
}
