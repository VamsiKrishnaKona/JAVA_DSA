package arrays.easy;

import java.util.*;

public class FindNumberThatAppearsOnce
{
    public static int bruteForce(int[] arr)
    {
        //Time complexity : O(n^2) because of 2 for loops
        for(int i = 0 ; i < arr.length ; i++)
        {
            int num = arr[i];
            int count = 0;
            for(int j = 0 ; j < arr.length ; j++)
            {
                if(arr[j] == num)
                {
                    count++;
                }
            }
            if(count == 1)
            {
                return num;
            }
        }
        return 0;
    }

    static int usingHashing(int[] arr)
    {
        int[] hashArray = new int[arr.length + 1];

        for(int i : arr)
        {
            hashArray[arr[i]]++;
        }

        for(int i = 0 ; i < hashArray.length ; i++)
        {
            if(hashArray[i] == 1)
            {
                return arr[i];
            }
        }
        return 0;
    }

    static int usingMap(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < arr.length ; i++)
        {
            int value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value+1);
        }

        for(Map.Entry<Integer, Integer> it : map.entrySet())
        {
            if(it.getValue() == 1)
            {
                return it.getKey();
            }
        }
        return 0;
    }

    static int usingXOR(int[] arr)
    {
        int xor = 0;
        for(int i = 0 ; i < arr.length ; i++)
        {
            xor = xor ^ arr[i];
        }
        return xor;
    }

    public static void main(String [] args)
    {
        int[] arr = {1,1,2,2,3,4,4};

        //System.out.println(bruteForce(arr));
        //System.out.println(usingHashing(arr));
        //System.out.println(usingMap(arr));
        System.out.println(usingXOR(arr));
    }
}
