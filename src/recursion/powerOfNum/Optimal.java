package recursion.powerOfNum;

public class Optimal
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

        while(nn > 0)
        {
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
        }

        if(nn < 0) return (double) 1.0/ (double) ans;

        return ans;
    }
}
