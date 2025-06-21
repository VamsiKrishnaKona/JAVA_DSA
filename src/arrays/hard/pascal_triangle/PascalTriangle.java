package arrays.hard.pascal_triangle;

import java.util.ArrayList;

public class PascalTriangle
{
    public static void main(String[] args)
    {
        int row = 5;

        printPascalTriangle(row);
    }

    private static void printPascalTriangle(int row)
    {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        for(int i = 1 ; i <= row ; i++)
        {
            triangle.add(printRow(i));
        }

        for(ArrayList<Integer> element : triangle)
        {
            System.out.println(element);
        }
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
