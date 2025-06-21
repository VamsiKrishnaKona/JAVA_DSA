package arrays.array_Rotations;

import java.util.Arrays;

public class Left_rotation_by_one_element
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{1,2,3,4,5,6};

        leftRotate(arr);
    }

    public static void leftRotate(int[] arr)
    {
        int i;
        int temp = arr[0];
        for(i = 1 ; i < arr.length ; i++)
        {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;

        System.out.print(Arrays.toString(arr));
    }
}
