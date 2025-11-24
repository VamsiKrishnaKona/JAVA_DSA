package first_JAVA;

import java.util.Scanner;

public class Fibonacci
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        {
            int number = sc.nextInt();


            fibonacci(number);
        }

    }

    private static void fibonacci(int number) {

        int n1 = 0, n2 = 1, n3 = 0;
        while(n3 <= number)
        {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }

    }

}
