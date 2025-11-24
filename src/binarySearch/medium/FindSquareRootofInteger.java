package binarySearch.medium;


public class FindSquareRootofInteger
{
    public static void main(String[] args)
    {
        int n = 80;
        //int ans = bruteForce(n);
        int optimal = optimal(n);

        //System.out.println(ans);
        System.out.println(optimal);

    }

    public static int bruteForce(int n)
    {
        int ans = 1;
        for(int i = 1; i <= n; i++)
        {
            if(i * i <= n)
            {
                ans = i;
            }
            else
            {
                break;
            }
        }
        return ans;
    }

    public static int optimal(int num)
    {
        int ans = 1;
        int start = 1;
        int end = num;

        while(start <= end)
        {
            int mid = start + (end - start)/2;

            if(mid * mid <= num)
            {
                ans = mid;
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return ans;
    }
}
