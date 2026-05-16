package DP.twoD.uniquePaths;

public class Memoization
{
    public static void main(String[] args) {

        int m = 3, n = 7;

        int uniquePaths = findUniquePaths(m, n);

        System.out.println(uniquePaths);
    }

    private static int findUniquePaths(int m, int n)
    {
        int[][] dp = new int[m][n];

        return solve(m - 1, n - 1, dp);
    }

    private static int solve(int row, int col, int[][] dp)
    {
        if(row == 0 && col == 0) return dp[0][0] = 1;

        int count = 0;

        if(row > 0)
        {
            count += solve(row - 1, col, dp);
        }

        if(col > 0)
        {
            count += solve(row, col - 1, dp);
        }

        return dp[row][col] = count;
    }
}
