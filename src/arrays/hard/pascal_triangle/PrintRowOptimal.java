package arrays.hard.pascal_triangle;

import java.util.ArrayList;

public class PrintRowOptimal
{
    public static void main(String[] args)
    {
        int row = 6;
        ArrayList<Integer> ans = printRow(row);

        System.out.print(ans);
    }

    private static ArrayList<Integer> printRow(int n)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        int res = 1;
        ans.add(res);

        for(int i = 1 ; i < n ; i++)
        {
            res = res * (n - i);
            res = res / (i);

            ans.add(res);
        }
        return ans;
    }
}
