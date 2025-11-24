package sorting;
<<<<<<< HEAD

import java.util.Arrays;
import java.util.Scanner;
=======
import java.util.*;
import java.lang.*;
>>>>>>> origin/krishna

public class    MergeSort
{
    static void merge(int[] arr, int low, int mid, int high)
    {
        int[] temp = new int[arr.length];
        int i = low;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= high)
        {
            if(arr[i] < arr[j])
            {
                temp[k] = arr[i];
                i++;
                k++;
            }
            else
            {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        while(i <= mid)
        {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while(j <= high)
        {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for(int x = low ; x <= high ; x++)
        {
            arr[x] = temp[x - low];
        }
    }
    public static void mergeSort(int[] arr, int low, int high)
    {

        if(low >= high)
            return;

        int mid = (low+high)/2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();

        int[] arr = new int[length];

        for(int i = 0 ; i < length ; i++)
        {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr,0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }
}
