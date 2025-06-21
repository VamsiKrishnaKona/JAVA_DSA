package linearSearch;
import java.util.*;

public class LinearSearch_INT
{
    public static int linearSearch(int[] arr, int target)
    {
        if(arr.length < 2)
        {
            return 0;
        }

        for(int i = 0 ; i < arr.length ; i++ )
        {
            if(arr[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String [] args)
    {
        int[] arr = new int[]{1,2,3,4,5};
        int len = arr.length;

        int target = 5;

        int ans = linearSearch(arr, target);

        if(ans == -1)
        {
            System.out.println("Element not found.");
        }
        else if(ans == 0)
        {
            System.out.println("Array has insufficient elements.");
        }
        else
        {
            System.out.println("the element you are searching for is "+target+" located at index of "+ans);
        }
    }
}
