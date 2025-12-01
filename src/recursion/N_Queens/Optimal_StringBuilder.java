package recursion.N_Queens;

import java.util.*;

public class Optimal_StringBuilder
{
    public static void main(String [] args)
    {
        int n = 4;
        List<List<StringBuilder>> possibilities = new ArrayList<>();
        n_Queens(n, possibilities);

        for (int i = 0; i < possibilities.size(); i++)
        {
            System.out.println("Solution " + (i + 1) + ":");
            for (StringBuilder row : possibilities.get(i))
            {
                System.out.println(row.toString());
            }
            System.out.println();
        }
    }

    public static List<List<StringBuilder>> n_Queens(int n, List<List<StringBuilder>> possibilities)
    {
        int col = 0;
        List<StringBuilder> board = new ArrayList<>();

        StringBuilder s = new StringBuilder(".".repeat(n));

        for(int i = 0 ; i < n ; i++)
        {
            board.add(new StringBuilder(s));
        }

        List<Integer> leftRow = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> lowerDiagonal = new ArrayList<>(Collections.nCopies(2*n - 1, 0));
        List<Integer> upperDiagonal = new ArrayList<>(Collections.nCopies(2*n - 1, 0));

        solve(n, col, board, possibilities, leftRow, lowerDiagonal, upperDiagonal);

        return possibilities;
    }

    public static void solve(int n, int col, List<StringBuilder> board, List<List<StringBuilder>> possibilities,
                             List<Integer> leftRow, List<Integer> lowerDiagonal, List<Integer> upperDiagonal)
    {
        if(col >= n)
        {
            List<StringBuilder> copy = new ArrayList<>();
            for (StringBuilder sb : board) {
                copy.add(new StringBuilder(sb.toString()));
            }
            possibilities.add(copy);
            return;
        }

        for(int row = 0 ; row < n ; row++)
        {
            if(leftRow.get(row) == 0 && lowerDiagonal.get(row + col) == 0 && upperDiagonal.get((n - 1) + col - row) == 0)
            {
                board.get(row).setCharAt(col, 'Q');
                leftRow.set(row, 1);
                lowerDiagonal.set(row + col, 1);
                upperDiagonal.set((n - 1) + col - row, 1);
                solve(n, col + 1, board, possibilities, leftRow, lowerDiagonal, upperDiagonal);
                board.get(row).setCharAt(col, '.');
                leftRow.set(row, 0);
                lowerDiagonal.set(row + col, 0);
                upperDiagonal.set((n - 1) + col - row, 0);

            }
        }
    }
}
