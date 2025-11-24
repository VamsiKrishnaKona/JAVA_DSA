package arrays.array_Rotations;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArrayBy_N_Elements
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int[] arr = new int[len];

        for(int i = 0 ; i < len ; i++)
        {
            arr[i] = sc.nextInt();
        }

        int n = sc.nextInt();

        //better(len,arr,n);
        optimal(len,arr,n);

        System.out.println(Arrays.toString(arr));

    }

    /////////////////////////////////////////////////////////////////

    public static void better(int len, int[] arr, int n)
    {
        n = n % len;

        int[] temp = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            temp[i] = arr[i];
        }

        for(int i = n ; i < len ; i++)
        {
            arr[i - n] = arr[i];
        }

        for(int i = len - n ; i < len ; i++)
        {
            arr[i] = temp[i - (len - n)];
        }

        for(int i = 0 ; i < len ; i++)
        {
            System.out.print(arr[i]+ " ");
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    public static void optimal(int len, int[] arr, int n)
    {
        reverse(arr,0, len - n - 1);
        reverse(arr, len - n, len - 1);
        reverse(arr, 0, len - 1);

    }

    public static void reverse(int[] arr, int start, int end)
    {

        int temp = 0;

        while(start <= end )
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
