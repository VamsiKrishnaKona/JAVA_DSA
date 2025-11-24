package loops;

import java.util.Scanner;

public class HCF
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();

        hcf(number1,number2);
    }

    static void hcf(int n1, int n2)
    {
        int GCD = 1;
        for(int i = 1 ; i <= n1 || i <= n2 ; i++)
        {
            if( n1 % i == 0 && n2 % i == 0)
            {
                GCD = i;
            }
        }
        System.out.println("HCF of "+ n1 +" and "+ n2 +" is "+ GCD);
    }
}
