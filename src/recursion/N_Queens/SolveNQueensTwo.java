package recursion.N_Queens;

public class SolveNQueensTwo
{
    public static void main(String[] args)
    {
        int n = 4;
        int possibilities = totalNQueens(n);

        System.out.println(possibilities);
    }

    public static int totalNQueens(int n)
    {
        char[][] board = new char[n][n];

        for (int r = 0; r < n; r++)
        {
            for (int c = 0; c < n; c++) board[r][c] = '.';
        }

        int col = 0;

        boolean[] leftRow = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2 * n - 1];
        boolean[] upperDiagonal = new boolean[2 * n - 1];

        return solve(col, n, board, leftRow, lowerDiagonal, upperDiagonal);
    }

    public static int solve(int col, int n, char[][] board, boolean[] leftRow, boolean[] lowerDiagonal, boolean[] upperDiagonal)
    {
        int value = 0;

        if(col >= n)
        {
            return 1;
        }

        for(int row = 0 ; row < n ; row++)
        {
            if(!leftRow[row] && !lowerDiagonal[row + col] && !upperDiagonal[(n - 1) + col - row])
            {
                board[row][col] = 'Q';
                leftRow[row] = true;
                lowerDiagonal[row + col] = true;
                upperDiagonal[(n - 1) + col - row] = true;

                value = value + solve(col + 1, n, board, leftRow, lowerDiagonal, upperDiagonal);

                board[row][col] = '.';
                leftRow[row] = false;
                lowerDiagonal[row + col] = false;
                upperDiagonal[(n - 1) + col - row] = false;
            }
        }

        return value;
    }
}
