package DP.twoD.traingleMinPathSum;

public class Recursive
{
    public static void main(String[] args) {

        int[][] triangle = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };

        int minPathSum = findMinPathSum(triangle);

        System.out.println(minPathSum);
    }

    public static int findMinPathSum(int[][] triangle)
    {
        int i = 0;
        int j = 0;

        return solve(triangle, i, j);
    }

    private static int solve(int[][] triangle, int i, int j)
    {
        if(i == triangle.length - 1) return triangle[i][j];

        int diagonal = triangle[i][j] + solve(triangle, i + 1, j + 1);
        int down = triangle[i][j] + solve(triangle, i + 1, j);

        return Math.min(diagonal, down);
    }
}
