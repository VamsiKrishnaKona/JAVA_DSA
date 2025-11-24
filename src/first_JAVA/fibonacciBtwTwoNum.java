package first_JAVA;

import java.util.Scanner;

public class fibonacciBtwTwoNum
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        printFib(n1,n2);
    }
    public static void printFib(int start, int end)
    {
        int n1 = 0, n2 = 1;

        if(start == 0)
        {
            System.out.print(n1 + " ");
        }

        for(int i = start ; i <= end ; i++)
        {
            System.out.print(n2 + " ");
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
    }
}
