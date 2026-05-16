package DP.twoD.minimumPathSum;

public class Recursive
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

        return solve(matrix, m - 1, n - 1);
    }

    private static int solve(int[][] matrix, int m, int n)
    {
        if(m == 0 && n == 0)
        {
            return matrix[0][0];
        }

        int up = Integer.MAX_VALUE;
        int left =  Integer.MAX_VALUE;

        if(m > 0) up = matrix[m][n] + solve(matrix, m - 1, n);
        if(n > 0) left = matrix[m][n] + solve(matrix, m, n - 1);

        return Math.min(up, left);
    }
}
