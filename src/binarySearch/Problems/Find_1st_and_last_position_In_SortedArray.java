package binarySearch.Problems;

import java.util.Arrays;

public class Find_1st_and_last_position_In_SortedArray
{
    public static void main(String[] args)
    {
        int[] numbs = new int[]{5,7,7,7,7,8,8,8,10};
        int target = 8;

        int[] ans = searchRange(numbs, target);


        //this is done by using binarySearch.
        //System.out.println(Arrays.toString(ans));

        //this is done by using two pointer approach.
        System.out.println(Arrays.toString(bruteForce(numbs, target)));
    }

    private static int[] searchRange(int[] numbs, int target)
    {

        int[] ans = {-1,-1};

        ans[0] = searchIndex(numbs,target,true);

        if(ans[0] != -1)
        {
            ans[1] = searchIndex(numbs,target,false);
        }


        return ans;
    }

    private static int searchIndex(int[] numbs, int target, boolean findStartIndex)
    {
        int ans = -1;
        int start = 0;
        int end = numbs.length - 1;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(target < numbs[mid])
            {
                end = mid - 1;
            }
            else if(target > numbs[mid])
            {
                start = mid + 1;
            }
            else
            {
                ans = mid;
                if(findStartIndex)
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

    public static int[] bruteForce(int[] arr, int target)
    {
        int[] ans = {-1, -1};

        int i = 0;
        int j = arr.length - 1;

        while(i < j)
        {
            if(arr[i] == target)
            {
                ans[0] = i;
            }

            if(arr[j] == target)
            {
                ans[1] = j;
            }

            i++;
            j--;
        }
        return ans;
    }
}
