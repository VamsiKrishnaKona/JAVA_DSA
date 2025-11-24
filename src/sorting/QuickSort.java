package sorting;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.Scanner;
=======
import java.util.*;
>>>>>>> origin/krishna

public class QuickSort
{
    public static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[0];
        int i = low;
        int j = high;

        while(i < j)
        {
            while(arr[i] <= pivot && i < high)
            {
                i++;
            }

            while(arr[j] > pivot && j > low)
            {
                j--;
            }

            if(i < j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }
    public static void qs(int[] arr, int low, int high)
    {
        if(low < high)
        {
            int pIndex = partition(arr, low, high);
            qs(arr, low,pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int[] arr = new int[length];
        for(int i = 0 ; i < length ; i++)
        {
            arr[i] = sc.nextInt();
        }

        int low = 0;
        int high = arr.length - 1;

        qs(arr, low, high);

        System.out.println(Arrays.toString(arr));
    }
}
