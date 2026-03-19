package Bit_Manipulation.Math.basics.checkPrimeOrNot;

public class Better
{
    public static void main(String[] args)
    {
        int n = 11;
        System.out.println(checkPrimeOrNot(n));
    }

    // T.C = o(n/2)
    private static boolean checkPrimeOrNot(int num)
    {
        if(num <= 1) return false;

        for(int i = 2 ; i <= num / 2 ; i++)
        {
            if(num % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
