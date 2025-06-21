package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort
{

    static void selectionSort1(int len, int[] arr)
    {
        for(int i = 0 ; i < len - 1 ; i++)
        {
            int mini = i;
            for(int j = i+1 ; j <= len - 1 ; j++)
            {
                if(arr[j] < arr[mini])
                {
                    mini = j;
                }
            }
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();

        int[] arr = new int[len];
        for(int i = 0 ; i < len ; i++)
        {
            arr[i] = sc.nextInt();
        }

        selectionSort(len, arr);
    }

    static void selectionSort(int len, int[] arr)
    {
        for(int i = 0 ; i < len - 1 ; i++)
        {
            int min = i;
            for(int j = i + 1 ; j <= len - 1 ; j++)
            {
                if(arr[j] < arr[min])
                {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
