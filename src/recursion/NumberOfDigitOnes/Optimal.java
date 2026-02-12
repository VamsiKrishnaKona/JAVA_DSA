package recursion.NumberOfDigitOnes;

public class Optimal
{
    public static void main(String[] args)
    {
        int n = 100;

        int onesCount = findOnesCount(n, 1, 0);

        System.out.println(onesCount);
    }

    private static int findOnesCount(int num, int i, int ans)
    {
        if(i > num)
        {
            return ans;
        }

        int div = i * 10;
        int q = num / div;
        int rem = num % div;

        ans += q * i;

        if(rem >= i)
        {
            ans += Integer.min(rem - i + 1, i);
        }

        return findOnesCount(num, i * 10, ans);
    }

}
