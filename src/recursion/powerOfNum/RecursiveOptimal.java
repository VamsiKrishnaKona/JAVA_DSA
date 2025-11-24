package recursion.powerOfNum;

public class RecursiveOptimal
{
    public static void main(String[] args)
    {
        double x = 2.0;
        int n = 10;

        double power = findPow(x,n);

        System.out.println(power);
    }

    private static double findPow(double x, int n)
    {
        double ans = 1.0;
        long nn = n;

        if(nn < 0) nn = -1 * nn;

        ans = func(ans, x, nn);

        if(n < 0) return 1.0 / ans;

        return ans;
    }

    private static double func(double ans, double x, long nn)
    {
        if(nn <= 0) return ans;

        if(nn % 2 == 1)
        {
            ans = ans * x;
            nn = nn - 1;
        }
        else
        {
            x = x * x;
            nn = nn / 2;
        }

        return func(ans, x, nn);
    }
}
