package arrays.medium;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray
{
    private static ArrayList<Integer> leadersInArray(int[] arr)
    {
        int len = arr.length;

        ArrayList<Integer> ans = new ArrayList<>();

        int max = -1;

        for(int i = len - 1 ; i >= 0 ; i--)
        {
            if(arr[i] > max)
            {
                ans.add(arr[i]);
                max = Math.max(max, arr[i]);
            }
        }

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{10, 22, 12, 0, 4, 6};

        ArrayList<Integer> ans = leadersInArray(arr);

        System.out.print(ans);

    }
}
