package loops;

import java.util.Scanner;

public class PrimesBetweenTwoNumbers
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        PrintPrimes(n1, n2);

        sc.close();
    }

    private static void PrintPrimes(int n1, int n2)
    {
        for(int i = n1 ; i <= n2 ; i++)
        {
            isPrime(i);
        }
    }

    private static void isPrime(int num)
    {
        int flag = 0;
        if(num < 2)
        {
            flag = 1;
        }

        for(int i = 2 ; i <= num/2 ; i++)
        {
            if(num % i == 0)
            {
                flag = 1;
                break;
            }
        }

        if(flag == 0)
        {
            System.out.print(" "+num);
        }
    }
}
