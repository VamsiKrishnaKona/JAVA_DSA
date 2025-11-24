package arrays.hard.pascal_triangle;

public class PrintRow
{
    public static void main(String[] args)
    {
        int n = 5;
        int r = 3;

        printRow(n);
    }

    private static void printRow(int n)
    {
        for(int c = 1 ; c <= n ; c++)
        {
            System.out.print(ncr(n - 1, c - 1) + " ");
        }
    }

    private static int ncr(int n, int r)
    {
        int resultant = 1;

        for(int i = 0 ; i < r ; i++)
        {
            resultant = resultant * (n - i);
            resultant = resultant / (i + 1);
        }

        return resultant;
    }
}
