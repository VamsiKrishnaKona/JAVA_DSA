package arrays.easy;

import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class SecondMinAndMax
{
    public static void main(String[] args)
    {


        int[] arr = new int[]{1,6,3,7,2,5,3,3,3};

        secondMaxAndMin(arr);
        //bruteForce(len,arr);
    }

    static void secondMaxAndMin(int[] arr) {

        if (arr.length == 0 || arr.length == 1) {
            System.out.println("Invalid Array or Array length is not Capable");
        }
        else
        {
            int small = Integer.MAX_VALUE;
            int second_small = Integer.MAX_VALUE;

            int big = Integer.MIN_VALUE;
            int second_Largest = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length - 1; i++) {
                small = min(small, arr[i]);
                big = max(big, arr[i]);
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < second_small && arr[i] != small) {
                    second_small = arr[i];
                }

                if (arr[i] > second_Largest && arr[i] != big) {
                    second_Largest = arr[i];
                }
            }

            System.out.println("Second smallest is " + second_small);
            System.out.println("Second largest is " + second_Largest);
        }

    }

    public static void bruteForce(int len, int[] arr)
    {
        Arrays.sort(arr);
        System.out.println(arr[arr.length - 2]);
    }

}
