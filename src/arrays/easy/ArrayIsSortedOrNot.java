package arrays.easy;

import java.util.Scanner;

public class ArrayIsSortedOrNot
{
    public static int checkArr(int len, int[] arr)
    {
        for(int i = 1 ; i < len ; i++)
        {
            if(arr[i] < arr[i - 1]) {
                return 1;
            }
        }
        return 0;

    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1,2,2,3,3,4,2};
        int len = arr.length;
        int sol = checkArr(len,arr);


        if(sol == 0)
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }
    }
}
