package DP.twoD.traingleMinPathSum;

public class Tabulation
{
    public static void main(String[] args)
    {
        int[][] triangle = {
//                {2},
//                {3, 4},
//                {6, 5, 7},
//                {4, 1, 8, 3}
                {-1},
                {-2,-3},
                {-4,-5,-6}
        };

        int minPathSum = findMinPathSum(triangle);

        System.out.println(minPathSum);
    }

    public static int findMinPathSum(int[][] triangle)
    {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        int min = 0;
        for(int i = 0 ; i < n ; i++)
        {
            min = Integer.MAX_VALUE;
            for(int j = 0 ; j < triangle[i].length ; j++)
            {
                if(i == 0 && j == 0) dp[i][j] = triangle[i][j];
                else
                {
                    int diagonal = Integer.MAX_VALUE;
                    int down = Integer.MAX_VALUE;
                    if(j > 0) diagonal = triangle[i][j] + dp[i-1][j - 1];
                    if(j < triangle[i].length - 1) down = triangle[i][j] + dp[i-1][j];

                    dp[i][j] = Math.min(down, diagonal);
                }
                min = Math.min(min, dp[i][j]);
            }
        }
        return min;
    }
}
