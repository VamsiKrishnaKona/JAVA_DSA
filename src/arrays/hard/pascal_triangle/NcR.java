package arrays.hard.pascal_triangle;

import java.util.Scanner;

public class NcR
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = 10;
        int r = 3;

        int resultant = find_nCr(n, r);

        System.out.println(resultant);
    }

    private static int find_nCr(int n, int r)
    {
        int resultant = 1;

        for(int i = 1 ; i <= r ; i++)
        {
            resultant = resultant * (n - 1);
            resultant = resultant / i;
        }

        return resultant;
    }
}

