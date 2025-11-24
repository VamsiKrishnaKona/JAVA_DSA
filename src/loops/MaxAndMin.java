package loops;

import java.util.Scanner;

public class MaxAndMin
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n1, n2, n3;
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        n3 = sc.nextInt();

        printMaxAndMin(n1, n2, n3);
        sc.close();

    }

    private static void printMaxAndMin(int n1, int n2, int n3)
    {
        int max = 0, min = 0;

        if( n1 > n2 && n1 > n3)
        {
            max = n1;

        }
        else if(n2 > n1 && n2 > n3)
        {
            max = n2;
        }
        else
        {
            max = n3;
        }

        if(n1 < n2 && n1 < n3)
        {
            min = n1;
        }
        else if(n2 < n1 && n2 < n3)
        {
            min = n2;
        }
        else
        {
            min = n3;
        }

        System.out.println("Max : " + max + " min : " + min);

    }
}
