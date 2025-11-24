package arrays.easy;

import java.util.Scanner;

public class ArrayDemo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        createArray(sc, size);

        sc.close();
    }

    // Creating the array using method and methodCalling.
    static void createArray(Scanner sc, int size)
    {
        int[] array = new int[size];

        for(int i = 0 ; i < size ; i++)
        {
            array[i] = sc.nextInt();
            System.out.print(" " + array[i]);
        }
    }
}
