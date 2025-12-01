package recursion.N_Queens;

import java.util.*;
import java.util.List;

public class Optimal_String
{
    public static void main(String [] args)
    {
        int n = 4;
        List<List<String>> possibilities = solveNQueens(n);

        for (int i = 0; i < possibilities.size(); i++)
        {
            System.out.println("Solution " + (i + 1) + ":");
            for (String row : possibilities.get(i))
            {
                System.out.println(row.toString());
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens(int n)
    {
        List<List<String>> possibilities = new ArrayList<>();
        List<String> board = new ArrayList<>();

        String s = ".".repeat(n);

        for(int i = 1 ; i <= n ; i++)
        {
            board.add(new String(s));
        }

        List<Integer> leftRow = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> lowerDiagonal = new ArrayList<>(Collections.nCopies(2*n - 1, 0));
        List<Integer> upperDiagonal = new ArrayList<>(Collections.nCopies(2*n - 1, 0));

        int col = 0;

        solve(n, col, board, possibilities, leftRow, lowerDiagonal, upperDiagonal);

        return possibilities;
    }

    public static void solve(int n, int col, List<String> board, List<List<String>> possibilities, List<Integer> leftRow, List<Integer> lowerDiagonal, List<Integer> upperDiagonal)
    {
        if(col >= n)
        {
            possibilities.add(new ArrayList<>(board));
            return;
        }

        for(int row = 0 ; row < n ; row++)
        {
            if(leftRow.get(row) == 0 && lowerDiagonal.get(row + col) == 0 && upperDiagonal.get((n - 1) + (col - row)) == 0)
            {
                char[] chars = board.get(row).toCharArray();
                chars[col] = 'Q';
                String updated = new String(chars);
                board.set(row, updated);
                leftRow.set(row, 1);
                lowerDiagonal.set(row + col, 1);
                upperDiagonal.set((n - 1) + col - row, 1);

                solve(n, col + 1, board, possibilities, leftRow, lowerDiagonal, upperDiagonal);

                chars[col] = '.';
                updated = new String(chars);
                board.set(row, updated);
                leftRow.set(row, 0);
                lowerDiagonal.set(row + col, 0);
                upperDiagonal.set((n - 1) + col - row, 0);
            }
        }
    }
}
