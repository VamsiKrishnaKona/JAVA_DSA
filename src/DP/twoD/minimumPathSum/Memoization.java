package DP.twoD.minimumPathSum;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args) {

        int[][] nums = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {2, 1, 1}
        };

        int minPathSUm = findMinimumPath(nums);
        System.out.println(minPathSUm);
    }

    private static  int findMinimumPath(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return solve(matrix, m - 1, n - 1, dp);
    }

    private static int solve(int[][] matrix, int m, int n, int[][] dp)
    {
        if(dp[m][n] != -1) return dp[m][n];

        if(m == 0 && n == 0)
        {
            return dp[0][0] = matrix[0][0];
        }

        int up = Integer.MAX_VALUE;
        int left =  Integer.MAX_VALUE;

        if(m > 0) up = matrix[m][n] + solve(matrix, m - 1, n, dp);
        if(n > 0) left = matrix[m][n] + solve(matrix, m, n - 1, dp);

        return dp[m][n] = Math.min(up, left);
    }
}
