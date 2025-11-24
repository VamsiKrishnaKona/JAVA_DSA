package first_JAVA;

import java.util.Scanner;

public class Armstrong
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        checkArmstrong(number);
    }

    static void checkArmstrong(int num)
    {
        int rem = 0, arm = 0, og = num;
        while(num > 0)
        {
            rem = num % 10;
            arm = arm + (rem*rem*rem);
            num = num/10;
        }

        if(arm == og)
        {
            System.out.print(og + " is true");
        }
        else
        {
            System.out.print(og + " is false");
        }
    }
}
