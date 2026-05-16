package DP.twoD.cherryPickTwo;

import java.util.Arrays;

public class Memoization
{
    private static final int min = (int) -1e8;
    public static void main(String[] args) {

        int[][] grid = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };

        int maxCollectedCherries = findMaxCollectedCherries(grid);

        System.out.println(maxCollectedCherries);
    }

    private static int findMaxCollectedCherries(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for(int[][] twoD : dp)
        {
            for(int[] row : twoD)
            {
                Arrays.fill(row, -1);
            }
        }
        return solve(0, 0, m - 1, n, m, grid, dp);
    }

    private static int solve(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp)
    {
        if(j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) return min;

        if(i == n - 1)
        {
            if(j1 == j2) return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != -1)  return dp[i][j1][j2];

        int max = min;
        for(int dj1 = -1 ; dj1 <= 1 ; dj1++)
        {
            for(int dj2 = -1 ; dj2 <= 1 ; dj2++)
            {
                int value = 0;

                if(dj1 == dj2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];

                value += solve(i + 1, j1 + dj1, j2 + dj2, n, m, grid, dp);

                max = Math.max(max, value);
            }
        }

        return dp[i][j1][j2] = max;
    }
}
