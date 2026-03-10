package Bit_Manipulation.interviewProblems;

public class Division
{
    public static void main(String[] args) {

        int dividend = 22;
        int divisor = -3;

        int division = divide(dividend, divisor);
        System.out.println(division);
    }

    private static int divide(int num, int den)
    {
        if (num == Integer.MIN_VALUE && den == -1) return Integer.MAX_VALUE;

        boolean sign = true;
        if(num < 0 && den > 0) sign = false;
        if(num > 0 && den < 0) sign = false;

        long dividend = Math.abs(num);
        long divisor = Math.abs(den);

        long ans = 0;

        while(dividend >= divisor)
        {
            int count = 0;
            while(dividend >= (divisor << (count + 1)))
            {
                count++;
            }

            dividend -= (divisor << count);
            ans += (1L << count);
        }
        if(ans > Integer.MAX_VALUE && sign) return Integer.MAX_VALUE;
        if(ans > Integer.MAX_VALUE && !sign) return Integer.MIN_VALUE;

        if(!sign) return -1 * (int)ans;
        return (int)ans;
    }
}
