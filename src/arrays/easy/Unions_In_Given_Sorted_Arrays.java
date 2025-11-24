package arrays.easy;

import java.util.ArrayList;
import java.util.HashSet;

public class Unions_In_Given_Sorted_Arrays
{
    public static void main(String[] args)
    {
        int[] arr1 = {1,1,2,3,4,5,7};
        int[] arr2 = {2,3,4,4,5,6};

        ArrayList<Integer> arr = findUnions(arr1, arr2);

        for(int i : arr)
        {
            System.out.print(i + " ");
        }
        //bruteForce(arr1, arr2);
    }

    static ArrayList<Integer> findUnions(int[] arr1, int[] arr2)
    {
        int i = 0;
        int j = 0;
        ArrayList<Integer> al = new ArrayList<>();

        while(i < arr1.length && j < arr2.length)
        {
            if(arr1[i] <= arr2[j])
            {
                if(al.isEmpty() || al.getLast() != arr1[i])
                {
                    al.add(arr1[i]);
                }
                i++;
            }
            else
            {
                if(al.isEmpty() || al.getLast() != arr2[j])
                {
                    al.add(arr2[j]);
                }
                j++;
            }
        }

        while(i < arr1.length)
        {
            if(al.getLast() != arr1[i])
            {
                al.add(arr1[i]);
            }
            i++;
        }

        while(j < arr2.length)
        {
            if(al.getLast() != arr2[j])
            {
                al.add(arr2[j]);
            }
            j++;
        }
        return al;
    }

    static void bruteForce(int[] arr1, int[] arr2)
    {
        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0 ; i < arr1.length ; i++)
        {
            hs.add(arr1[i]);
        }

        for(int i = 0 ; i < arr2 .length ; i++)
        {
            hs.add(arr2[i]);
        }

        ArrayList<Integer> al = new ArrayList<>(hs);

        for(int num : al)
        {
            System.out.print(num + " ");
        }

    }
}
