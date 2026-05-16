package DP.twoD.uniquePaths2;

//Directly Optimized from uniquePaths Problem
public class optimal
{
    public static void main(String[] args)
    {
        int[][] grid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int uniquePaths = solve(grid);

        System.out.println(uniquePaths);
    }

    private static int solve(int[][] nums)
    {
        int m = nums.length;
        int n = nums[0].length;
        int[] prev = new int[n];

        for(int i = 0 ; i < m ; i++)
        {
            int[] curr = new int[n];
            for(int j = 0 ; j < n ; j++)
            {
                if(i == 0 && j == 0 && nums[i][j] != 1) curr[j] = 1;
                else
                {
                    if(nums[i][j] != 1)
                    {
                        int up = 0;
                        int left = 0;

                        if(i > 0) up = prev[j];
                        if(j > 0) left = curr[j - 1];
                        curr[j] = up + left;
                    }
                    else
                    {
                        curr[j] = 0;
                    }
                }
            }
            prev = curr;
        }

        return prev[n - 1];
    }
}
