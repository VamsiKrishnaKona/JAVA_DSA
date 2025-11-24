package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort
{

    public static void bubbleSort(ArrayList<Integer> arr, int len)
    {
        for(int i = 0 ; i <= len - 1 ; i++)
        {
            for(int j = 0 ; j <= len - 1 ; j++)
            {
                if(arr.get(j) > arr.get(j+1))
                {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }
            }
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>(length);
        for(int i = 0 ; i < length ; i++)
        {
            arr.add(sc.nextInt());
            //System.out.print(arr.get(i)+ " ");
        }

        bubbleSort(arr, length);

        for(int i = 0 ; i < length ; i++)
        {
            System.out.print(arr.get(i)+ " ");
        }

        sc.close();
    }
}
