package arrays.easy;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates
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

        //bruteForce(len,arr);
        int ans = optimal(len,arr);
        for(int i = 0 ; i < ans ; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bruteForce(int len, int[] arr)
    {
        HashSet<Integer> hs = new HashSet<> ();
        for (int i = 0; i < arr.length; i++)
        {
            hs.add(arr[i]);
        }

        System.out.print(hs+" ");
    }

    public static int optimal(int len, int[] arr)
    {
        int i = 0;

        for(int j = 1 ; j < arr.length ; j++)
        {
            if(arr[i] != arr[j])

            
            {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
}
