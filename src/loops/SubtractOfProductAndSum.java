package loops;

import java.util.Scanner;

public class SubtractOfProductAndSum
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        subtract(number);
    }

    private static void subtract(int num)
    {
        int product = 1 , sum = 0;
        while(num > 0)
        {
            int rem = num % 10;
            product = product*rem;
            sum = sum + rem;
            num = num / 10;
        }

        System.out.print(product + " - " + sum + " : ");

        int ans = product - sum;
        System.out.println(ans);
    }
}
