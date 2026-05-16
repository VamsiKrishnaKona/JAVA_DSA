package DP.twoD.maximumFallingPathSum;

import java.util.Arrays;

public class Memoization
{
    public static void main(String[] args)
    {
        int[][] grid = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}

        };

        int maxPathSum = findMaxFallingPathSum(grid);

        System.out.println(maxPathSum);
    }

    private static int findMaxFallingPathSum(int[][] grid)
    {
        int maxPathSum = Integer.MIN_VALUE;

        int m = grid.length;
        int n = grid[0].length;

        int i = 0;

        int[][] dp = new int[m][n];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }


        int dRight = Integer.MIN_VALUE;
        int down = Integer.MIN_VALUE;
        int dLeft = Integer.MIN_VALUE;

        for(int j = 0 ; j < n ; j++)
        {
            if(i < m - 1 && j < n - 1) dRight = grid[i][j] + solve(grid, i + 1, j + 1, dp);
            if(i < m - 1)  down = grid[i][j] + solve(grid, i + 1, j, dp);
            if(i < m - 1 && j > 0) dLeft = grid[i][j] + solve(grid, i + 1, j - 1, dp);

            int max = Math.max(dRight, Math.max(down, dLeft));
            maxPathSum = Math.max(max, maxPathSum);
            dp[i][j] = max;
        }
        return maxPathSum;
    }

    private static int solve(int[][] grid, int i, int j, int[][] dp)
    {
        int n = grid.length;
        int m = grid[0].length;
        if(i == n - 1) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];

        int right = Integer.MIN_VALUE;
        int down = Integer.MIN_VALUE;
        int left = Integer.MIN_VALUE;

        if(i < m - 1 && j < n - 1) right = grid[i][j] + solve(grid, i + 1, j + 1, dp);
        if(i < m - 1)  down = grid[i][j] + solve(grid, i + 1, j, dp);
        if(i < m - 1 && j > 0) left = grid[i][j] + solve(grid, i + 1, j - 1, dp);

        return dp[i][j] = Math.max(right, Math.max(down, left));
    }
}
