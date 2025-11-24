package arrays.easy;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.Scanner;
=======
import java.util.*;
>>>>>>> origin/krishna

public class SecondOrderElementsInArray
{
    public static int[] secondOrderElements(int len, int[] arr)
    {
        int secondLargestElement = sLargest(len, arr);
        int secondSmallestElement = sSmallest(len, arr);

        return new int[]{secondLargestElement,secondSmallestElement};
    }

    private static int sLargest(int len, int[] arr)
    {
        int largest = arr[0];
        int sLargest = Integer.MIN_VALUE;

        for(int i = 1 ; i < arr.length ; i++)
        {
            if(arr[i] > largest)
            {
                sLargest = largest;
                largest = arr[i];
            }
            else if(arr[i] != largest && arr[i] > sLargest)
            {
                sLargest = arr[i];
            }
        }
        return sLargest;
    }

    private static int sSmallest(int len, int[] arr)
    {
        int smallest = arr[0];
        int sSmallest = Integer.MAX_VALUE;

        for(int i = 0 ; i < arr.length ; i++)
        {
            if(arr[i] < smallest)
            {
                sSmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i] != smallest && arr[i] < sSmallest)
            {
                sSmallest = arr[i];
            }
        }

        return sSmallest;
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();

        int[] arr = new int[len];
        for(int i = 0 ; i < len ; i++)
        {
            arr[i] = sc.nextInt();
        }

        int[] ans= secondOrderElements(len,arr);
        System.out.println(Arrays.toString(ans));
    }
}
