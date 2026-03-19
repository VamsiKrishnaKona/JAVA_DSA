package Bit_Manipulation.Math.basics.checkPrimeOrNot;

public class Optimal
{
    public static void main(String[] args)
    {
        int n = 11;
        System.out.println(checkPrimeOrNot(n));
    }

    //T.C = o(sqrt(N))
    private static boolean checkPrimeOrNot(int num)
    {
        int count = 0;

        for(int i = 1 ; i * i <= num ; i++)
        {
            if(num % i == 0)
            {
                count++;
                if(num / i != i) count++;
            }
        }

        if(count == 2) return true;
        return false;
    }
}
