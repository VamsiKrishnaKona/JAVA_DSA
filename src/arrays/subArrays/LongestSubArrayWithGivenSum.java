package arrays.subArrays;

//this code works when array contains +ves, -ves
import java.util.*;

public class LongestSubArrayWithGivenSum
{
    public static void main(String [] args)
    {

        int[] arr = new int[]{1, -1, 3, 2, -2, -8, 1, 7, 10, 23};
        int k = 0;

        //System.out.println(bruteForce(arr, k));
        System.out.println(usingHashMap(arr, k));
        //System.out.println(twoPointer(arr, k));
    }

    private static int bruteForce(int[] arr, int k)
    {
        int maxLen = 0;

        for(int i = 0 ; i < arr.length ; i++)
        {
            int sum = 0;
            for(int j = i ; j < arr.length ; j++)
            {
                sum += arr[j];
                if(sum == k)
                {
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }

    private static int usingHashMap(int[] arr, int k)
    {
        int maxLen = 0;
        int sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i = 0 ; i < arr.length ; i++)
        {
            sum += arr[i];

            if(sum == k)
            {
                maxLen = Math.max(maxLen, i+1);
            }

            int rem = sum - k;

            if(mp.containsKey(rem))
            {
                int len = i - mp.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if(!mp.containsKey(sum))
            {
                mp.put(sum, i);
            }
        }
        return maxLen;
    }

    //this method only works when array contains only positives
    
    private static int twoPointer(int[] arr, int k)
    {
        int maxLen = 0;
        int sum = arr[0];
        int right = 0, left = 0;
        int arrLen = arr.length;

        while(right < arrLen)
        {
            while(left <= right && sum > k)
            {
                sum -= arr[left];
                left++;
            }

            if(sum == k)
            {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;

            if(right < arrLen)
                sum += arr[right];
        }

        return maxLen;
    }
}
