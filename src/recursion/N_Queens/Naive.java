package recursion.N_Queens;

import java.util.*;

public class Naive
{
    public static void main(String [] args)
    {
        int n = 4;
        List<List<StringBuilder>> possibilities = new ArrayList<>();
        n_Queens(n, possibilities);

        for (int i = 0; i < possibilities.size(); i++)
        {
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

        solve(n, col, board, possibilities);

        return possibilities;
    }

    public static void solve(int n, int col, List<StringBuilder> board, List<List<StringBuilder>> possibilities)
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
            if(isSafe(row, col, board, n))
            {
                board.get(row).setCharAt(col, 'Q');
                solve(n, col + 1, board, possibilities);
                board.get(row).setCharAt(col, '.');
            }
        }
    }

    public static boolean isSafe(int row, int col, List<StringBuilder> board, int n)
    {
        int r = row;
        int c = col;

        while(row >= 0 && col >= 0)
        {
            if(board.get(row).charAt(col) == 'Q')
            {
                return false;
            }
            row--;
            col--;
        }

        row = r;
        col = c;

        while(col >= 0)
        {
            if(board.get(row).charAt(col) == 'Q')
            {
                return false;
            }
            col--;
        }

        row = r;
        col = c;

        while(row < n && col >= 0)
        {
            if(board.get(row).charAt(col) == 'Q')
            {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }
}
