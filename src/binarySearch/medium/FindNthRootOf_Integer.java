package binarySearch.medium;

public class FindNthRootOf_Integer
{
    // find the Nth root of given number
    private static int bruteForce(int N, int M)
    {
        for(int i = 1 ; i < M ; i++)
        {
            int f = iteration_INTO_N(N, M, i);
            if(f == 1)
            {
                return i;
            }
            else if(f == 2)
            {
                break;
            }
        }

        return -1;
    }

    /// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static int iteration_INTO_N(int N, int M, int i)
    {
        int num = 1;

        for(int it = 1 ; it <= N ; it++)
        {
            num = num * i;

            if(num > M) return 2;
        }
        if(num == M) return 1;
        return 0;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static int optimal(int N, int M)
    {
        int start = 1;
        int end = M;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            int nthM = iteration_INTO_N(N, M, mid);

            if(nthM == 1)
            {
                return mid;
            }
            else if(nthM == 0)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int N = 4;
        int M = 69;

        int ans = bruteForce(N, M);

        System.out.println(ans);
    }
}
