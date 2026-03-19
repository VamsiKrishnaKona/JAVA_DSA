package Bit_Manipulation.Math.basics.printPrimeFactors;

public class Naive
{
    public static void main(String[] args)
    {
        int n = 60;
        printPrimeFactors(n);
    }

    //T.C = o(n * sqrt(n))
    private static void printPrimeFactors(int n)
    {
        for(int i = 1 ; i <= n ; i++)
        {
            if(n % i == 0)
            {
                if(isPrime(i)) System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int num)
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
