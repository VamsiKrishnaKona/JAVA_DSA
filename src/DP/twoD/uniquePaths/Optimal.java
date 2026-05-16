package DP.twoD.uniquePaths;

import java.util.Arrays;

public class Optimal
{
    public static void main(String[] args) {

        int m = 3, n = 7;

        int uniquePaths = solve(m , n);

        System.out.println(uniquePaths);
    }

    private static int solve(int m , int n)
    {
        int[] prev = new int[m];
        Arrays.fill(prev, 1);

        for(int i = 0 ; i < m ; i++)
        {
            int[] curr = new int[n];
            for(int j = 0 ; j < n ; j++)
            {
                if(i == 0 && j == 0) curr[j] = 1;
                else
                {
                    int up = 0;
                    int left = 0;

                    if(i > 0) up = prev[j];
                    if(j > 0) left = curr[j - 1];
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }

        return prev[n - 1];
    }
}
