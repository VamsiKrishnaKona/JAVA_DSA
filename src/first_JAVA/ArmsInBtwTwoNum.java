package first_JAVA;

import java.util.Scanner;

public class ArmsInBtwTwoNum
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        printArmstrong(n1,n2);
    }

    static void printArmstrong(int n1, int n2)
    {
        for(int i = n1 ; i <= n2 ; i++)
        {
            if(isArmstrongNumber(i))
            {
                System.out.print(i + " ");
            }
        }
    }

    static boolean isArmstrongNumber(int num)
    {
        int rem = 0, arm = 0, og = num;
        while(num > 0)
        {
            //int og = n1;
            rem = num % 10;
            arm = arm + (rem*rem*rem);
            num = num/10;
        }

        return arm == og;
    }
}
