package DP.twoD.maximumFallingPathSum;

public class Optimal
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

        int[] prev = new int[n];

        for(i = 0 ; i < m ; i++)
        {
            int[] curr = new int[n];
            for(int j = 0 ; j < n ; j++)
            {
                if(i == 0)
                {
                    curr[j] =  grid[i][j];
                }
                else
                {
                    int dRight = Integer.MIN_VALUE;
                    int down = Integer.MIN_VALUE;
                    int dLeft = Integer.MIN_VALUE;

                    if(j < n - 1) dRight = grid[i][j] + prev[j + 1];
                    down = grid[i][j] + prev[j];
                    if(j > 0) dLeft = grid[i][j] + prev[j - 1];

                    int max = Math.max(dRight, Math.max(down, dLeft));
                    curr[j] = max;

                }
            }
            prev = curr;
        }

        for(int j = 0; j < n; j++)
        {
            maxPathSum = Math.max(maxPathSum, prev[j]);
        }
        return maxPathSum;
    }
}
