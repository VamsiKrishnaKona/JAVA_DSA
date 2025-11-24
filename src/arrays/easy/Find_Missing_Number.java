package arrays.easy;

public class Find_Missing_Number
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,4,5};
        int n = 5;

        System.out.println(findMissingNumber(arr, n));
       //System.out.println(usingXOR(arr, n));
    }

    static int findMissingNumber(int[] arr, int n)
    {
        int sum = (n * (n + 1)) / 2;

        int sum2 = 0;
        for(int i = 0 ; i < n - 1 ; i++)
        {
            sum2 += arr[i];
        }
        return sum - sum2;
    }

    static int usingXOR(int[] arr, int n)
    {
        int xor1 = 0;
        int xor2 = 0;
        int N = n - 1;

        for(int i = 0 ; i < N ; i++)
        {
            xor2 = xor2 ^ arr[i];
            xor1 = xor1 ^ (i+1);
        }
        return xor1^xor2;
    }

}
