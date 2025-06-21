package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class test
{
    private static int[] findTripletSumEqualsK(int[] arr, int k)
    {
        Arrays.sort(arr);

        for(int i = 0 ; i < arr.length ; i++)
        {
            int right = arr.length - 1;
            int left = i + 1;

            int rem = k - arr[i];

            while(left < right)
            {
                if(arr[left] + arr[right] == rem)
                {
                    return new int[] {arr[i], arr[left], arr[right]};
                }
                else if(arr[left] + arr[right] < rem)
                {
                    left++;
                }
                else if(arr[left] + arr[right] > rem)
                {
                    right--;
                }

                while(arr[left] == arr[left + 1] && left < right)
                {
                    left++;
                }

                while(arr[right] == arr[right - 1] && left < right && right < arr.length - 1)
                {
                    right--;
                }
            }

            while(i > 0 && arr[i] == arr[i - 1]) i++;
        }
        return new int[]{-1, -1, -1};
    }
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i = 0 ; i < arr.length ; i++)
        {
            arr[i] = sc.nextInt();
        }

        int k = 18;

        int[] ans = findTripletSumEqualsK(arr, k);

        System.out.println(Arrays.toString(ans));
    }
}
