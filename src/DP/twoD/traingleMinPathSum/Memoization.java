package DP.twoD.traingleMinPathSum;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args)
    {
        int[][] triangle = {
                {-1},
                {-2,-3},
                {-4,-5,-6}
        };

        int minPathSum = findMinPathSum(triangle);

        System.out.println(minPathSum);
    }

    public static int findMinPathSum(int[][] triangle)
    {
        int i = 0;
        int j = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];

        for(int[] a : dp)
        {
            Arrays.fill(a, 0);
        }
        return solve(triangle, i, j, dp);
    }

    private static int solve(int[][] triangle, int i, int j, int[][] dp)
    {
        if(i == triangle.length - 1) return dp[i][j] = triangle[i][j];

        if(dp[i][j] != 0) return dp[i][j];

        int diagonal = triangle[i][j] + solve(triangle, i + 1, j + 1, dp);
        int down = triangle[i][j] + solve(triangle, i + 1, j, dp);

        return dp[i][j] = Math.min(diagonal, down);
    }
}
