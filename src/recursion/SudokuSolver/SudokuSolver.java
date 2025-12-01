package recursion.SudokuSolver;

public class SudokuSolver
{
    public static void main(String[] args)
    {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        sudokuSolver(board);

        for(int i = 0 ; i < board.length ; i++)
        {
            System.out.print("[ ");
            for(int j = 0 ; j < board[i].length ; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void sudokuSolver(char[][] board)
    {
        solve(board);
    }

    public static boolean solve(char[][] board)
    {
        int n = board.length;

        for(int row = 0 ; row < n ; row++)
        {
            for(int col = 0 ; col < board[row].length ; col++)
            {
                if(board[row][col] == '.')
                {
                    for(char c = '1' ; c <= '9' ; c++)
                    {
                        if(isValid(c, row, col, board))
                        {
                            board[row][col] = c;

                            if(solve(board))
                            {
                                return true;
                            }
                            else
                            {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char c, int row, int col, char[][] board)
    {
        for(int i = 0 ; i < 9 ; i++)
        {
            if(board[i][col] == c) return false;

            if(board[row][i] == c) return false;

            if(board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == c) return false;
        }
        return true;
    }

}
