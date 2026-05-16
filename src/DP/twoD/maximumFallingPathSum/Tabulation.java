package DP.twoD.maximumFallingPathSum;

public class Tabulation
{
    private static int findMaxFallingPathSum(int[][] grid)
    {
        int maxPathSum = Integer.MIN_VALUE;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(i == 0)
                {
                    dp[i][j] =  grid[i][j];
                }
                else
                {
                    int dRight = Integer.MIN_VALUE;
                    int down = Integer.MIN_VALUE;
                    int dLeft = Integer.MIN_VALUE;

                    if(j < n - 1) dRight = grid[i][j] + dp[i - 1][j + 1];
                    down = grid[i][j] + dp[i - 1][j];
                    if(j > 0) dLeft = grid[i][j] + dp[i - 1][j- 1];

                    int max = Math.max(dRight, Math.max(down, dLeft));
                    dp[i][j] = max;

                }
            }
        }

        for(int j = 0; j < n; j++)
        {
            maxPathSum = Math.max(maxPathSum, dp[m - 1][j]);
        }
        return maxPathSum;
    }
}
