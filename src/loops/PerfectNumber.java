package loops;

import java.util.Scanner;

public class PerfectNumber
{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        perfect(number);
    }

    private static void perfect(int num)
    {
        int sum = 0, og = num;
        for(int i = 1 ; i < num ; i++)
        {
            if(num % i == 0)
            {
                sum += i;
            }
        }
        if(sum == og)
        {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

}
