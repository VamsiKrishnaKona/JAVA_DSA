package recursion.N_Queens;

import java.util.*;

public class Optimal_Final
{
    public static void main(String[] args)
    {
        int n = 4;
        List<List<String>> possibilities = solveNQueens(n);

        for (int i = 0; i < possibilities.size(); i++) {
            System.out.println("Solution " + (i + 1) + ":");
            for (String row : possibilities.get(i)) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens(int n)
    {
        List<List<String>> possibilities = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++)
        {
            for (int c = 0; c < n; c++) board[r][c] = '.';
        }

        // use primitive boolean arrays instead of List<Integer>
        boolean[] rows = new boolean[n];
        boolean[] lowerDiag = new boolean[2 * n - 1];  // row + col
        boolean[] upperDiag = new boolean[2 * n - 1];  // (n-1) + (col - row)

        backtrack(n, 0, board, possibilities, rows, lowerDiag, upperDiag);
        return possibilities;
    }

    private static void backtrack(int n,
                                  int col,
                                  char[][] board,
                                  List<List<String>> possibilities,
                                  boolean[] rows,
                                  boolean[] lowerDiag,
                                  boolean[] upperDiag) {
        if (col >= n) {
            // convert char[][] row to String and add a copy
            List<String> solution = new ArrayList<>(n);
            for (int r = 0; r < n; r++) {
                solution.add(String.valueOf(board[r]));
            }
            possibilities.add(solution);
            return;
        }

        int diagOffset = n - 1; // used for upper diagonal indexing

        for (int r = 0; r < n; r++) {
            int ldIndex = r + col;
            int udIndex = diagOffset + (col - r);

            if (!rows[r] && !lowerDiag[ldIndex] && !upperDiag[udIndex]) {
                // place
                board[r][col] = 'Q';
                rows[r] = true;
                lowerDiag[ldIndex] = true;
                upperDiag[udIndex] = true;

                backtrack(n, col + 1, board, possibilities, rows, lowerDiag, upperDiag);

                // undo (backtrack)
                board[r][col] = '.';
                rows[r] = false;
                lowerDiag[ldIndex] = false;
                upperDiag[udIndex] = false;
            }
        }
    }
}
