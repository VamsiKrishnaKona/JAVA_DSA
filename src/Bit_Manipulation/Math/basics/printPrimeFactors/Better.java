package Bit_Manipulation.Math.basics.printPrimeFactors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Better
{
    public static void main(String[] args)
    {
        int n = 780;
        List<Integer> primeFactors = printPrimeFactors(n);
        System.out.println(primeFactors);
    }

    //T.C = o(sqrt(n) * 2 * sqrt(n)) we cannot predict exact one
    private static List<Integer> printPrimeFactors(int n)
    {
        List<Integer> primeFactors = new ArrayList<>();

        for(int i = 1 ; i <= Math.sqrt(n) ; i++)
        {
            if(n % i == 0)
            {
                if(isPrime(i))
                {
                    primeFactors.add(i);
                    if(n / i != i)
                    {
                        if(isPrime(n / i)) primeFactors.add(n / i);
                    }
                }
            }
        }

        Collections.sort(primeFactors);
        return primeFactors;
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
