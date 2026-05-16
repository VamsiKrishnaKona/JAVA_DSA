package DP.twoD.minimumPathSum;

public class Tabulation
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
        return solve(matrix, m - 1, n - 1, dp);
    }

    private static int solve(int[][] matrix, int m, int n, int[][] dp)
    {
        for(int i = 0 ; i <= m ; i++)
        {
            for(int j = 0 ; j <= n; j++)
            {
                int down = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if(i == 0 && j == 0) dp[i][j] = matrix[0][0];
                else
                {
                    if(i > 0) down =  matrix[i][j] + dp[i - 1][j];
                    if(j > 0) right =  matrix[i][j] + dp[i][j - 1];

                    dp[i][j] =  Math.min(down, right);
                }
            }
        }

        return dp[m][n];
    }
}
