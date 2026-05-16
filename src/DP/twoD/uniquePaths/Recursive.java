package DP.twoD.uniquePaths;

public class Recursive
{
    public static void main(String[] args) {

        int m = 3, n = 7;

        int uniquePaths = solve(m - 1, n - 1);

        System.out.println(uniquePaths);
    }

    private static int solve(int row, int col)
    {
        if(row == 0 && col == 0) return 1;

        int count = 0;

        if(row > 0)
        {
            count += solve(row - 1, col);
        }

        if(col > 0)
        {
            count += solve(row, col - 1);
        }

        return count;
    }
}
