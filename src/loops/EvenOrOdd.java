package loops;

import java.util.Scanner;

public class EvenOrOdd
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        checkEvenOrOdd(number);
    }

    private static void checkEvenOrOdd(int n)
    {
        if(n % 2 == 0)
        {
            System.out.println(n + " is Even");
        }
        else
        {
            System.out.println(n + " is Odd");
        }
    }
}
