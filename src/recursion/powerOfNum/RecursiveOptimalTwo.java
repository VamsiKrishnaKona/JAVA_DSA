package recursion.powerOfNum;

public class RecursiveOptimalTwo
{
    public static void main(String[] args)
    {
        double x = 2.0;
        int n = 10;

        int power = findPow(x,n);

        System.out.println(power);
    }

    private static int findPow(double x, int n)
    {
        if(n == 0) return 1;

        if(n < 0) return 1 / findPow(x, -n);

        int half = findPow(x, n/2);

        if(n % 2 == 0)
        {
            return half * half;
        }
        else
        {
            return (int) x * half * half;
        }
    }
}
