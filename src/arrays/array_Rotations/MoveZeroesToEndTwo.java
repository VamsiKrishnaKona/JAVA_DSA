package arrays.array_Rotations;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;
=======
import java.util.*;
>>>>>>> origin/krishna

public class MoveZeroesToEndTwo
{
    public static int[] bruteForce(int[] arr, int len)
    {
        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 0 ; i < len ; i++)
        {
            if(arr[i] != 0)
                al.add(arr[i]);
        }

        int nz = al.size();

        for(int i = 0 ; i < nz ; i++)
        {
            arr[i] = al.get(i);
        }

        for(int i = nz ; i < len ; i++)
        {
            arr[i] = 0;
        }

        return arr;
    }

    public static void main(String [] args)
    {
        int[] arr = new int[]{0,0,2,0,1,3};
        int len = arr.length;

        int[] ans = bruteForce(arr,len);

        System.out.println(Arrays.toString(ans));
    }
}
