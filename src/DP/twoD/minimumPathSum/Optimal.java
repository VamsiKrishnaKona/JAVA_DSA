package DP.twoD.minimumPathSum;

public class Optimal
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

        int[] prev = new int[n];
        prev[0] = matrix[0][0];
        for(int i = 0 ; i < m ; i++)
        {
            int[] curr = new int[n];
            for(int j = 0 ; j < n; j++)
            {
                int down = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if(i == 0 && j == 0) curr[j] = matrix[0][0];
                else
                {
                    if(i > 0) down =  matrix[i][j] + prev[j];
                    if(j > 0) right =  matrix[i][j] + curr[j - 1];

                    curr[j] =  Math.min(down, right);
                }
            }
            prev = curr;
        }

        return prev[n-1];


    }
}
