package loops;

import java.util.Scanner;

public class FactorsOfNum
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        printFactorsUsingFor(number);
    }

    public static void printFactorsUsingFor(int num)
    {
        for(int i = 1 ; i <= num ; i++)
        {
            if(num%i == 0)
            {
                System.out.print(i + " ");
            }
        }
    }

    public static void printFactorsUsingWhile(int num)
    {
        int i = 1;
        while(num > 0)
        {
            if(num % i == 0)
            {
                System.out.println(i+" ");
            }
            i++;
        }
    }
}
