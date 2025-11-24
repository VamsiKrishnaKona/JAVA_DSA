package loops;

import java.util.Scanner;

public class PrimeOrNot
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        primeOrNot(number);
    }

    private static void primeOrNot(int number)
    {
        int flag = 0;

        if(number <= 1)
        {
            flag = 1;
        }

        for(int i = 2 ; i <= number/2 ; i++)
        {
            if(number % i == 0) {

                flag = 1;
                break;
            }
        }

        if(flag == 0)
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }

    }
}
