// This code shows 3 ways to Reverse an Array. In methods and methodCalling from main function.

package arrays.easy;

import java.util.Scanner;

public class ReverseArray
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[] a = new int[size];
        for(int i = 0 ; i < a.length ; i++)
        {
            a[i] = sc.nextInt();
            System.out.print(" " + a[i]);
        }
        System.out.println();

        reverseArray(a);
        //reverseArrayOne(a);
        //reverseArrayTwo(a);
    }

    // This method works like iterating the given array from last array[array.length - 1] to 0 index which is array[0]
    public static void reverseArray(int[] a)
    {
        for(int i = a.length - 1 ; i >= 0 ; i--)
        {
            //System.out.print(" " + a[i]);
        }

        for(int i = 0 ; i < a.length ; i++)
        {
            int rev = a[a.length - 1 - i];
            System.out.print(" " + rev);
        }
    }

    // this method works like creating another array and printing the 1st array's elements from last to 0 in newly created array.
    public static void reverseArrayOne(int[] a)
    {
        int[] reverseArray = new int[a.length];

//        for(int i = a.length - 1 ; i >= 0 ; --i)
//        {
//            reverseArray[i] = a[i];
//            System.out.print(" " + reverseArray[i]);
//        }

        for(int i = 0 ; i < reverseArray.length ; i++)
        {
            reverseArray[i] = a[a.length - 1 - i];
            System.out.print(" " + reverseArray[i]);
        }
    }

    public static void reverseArrayTwo(int[] a)
    {
        int start = 0, end = a.length - 1;

        while(start < end)
        {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }

        for(int num : a)
        {
            System.out.print(" " + num);
        }
    }
}
