package arrays.easy;

import java.util.Scanner;

public class MaXAndMin
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[] a = new int[size];
        for(int i = 0 ; i < size ; i++)
        {
            a[i] = sc.nextInt();
        }

        maxAndMin(a);
    }

    static void maxAndMin(int[] a)
    {
        int max = 0, min = a[0];

        for(int i = 0 ; i < a.length ; i++)
        {
            if(max < a[i])
            {
                max = a[i];
            }

            if(min > a[i])
            {
                min = a[i];
            }
        }

        System.out.println("MAX : " + max);
        System.out.println("MIN : "+ min);

    }
}
