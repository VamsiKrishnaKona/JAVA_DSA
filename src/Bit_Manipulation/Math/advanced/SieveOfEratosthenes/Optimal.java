package Bit_Manipulation.Math.advanced.SieveOfEratosthenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Optimal
{
    public static void main(String[] args)
    {
        int num = 38;
        List<Integer> list = generatePrimes(num);
        System.out.println(list);
    }

    private static List<Integer> generatePrimes(int num)
    {
        List<Integer> primes = new ArrayList<>();

        int[] primeArray = new int[num + 1];
        Arrays.fill(primeArray, 1);

        for(int i = 2 ; i * i <= num ; i++)
        {
            if(primeArray[i] == 1)
            {
                for(int j = i * i ; j <= num ; j += i)
                {
                    primeArray[j] = 0;
                }
            }
        }

        for(int i = 2 ; i <= num ; i++)
        {
            if(primeArray[i] == 1) primes.add(i);
        }

        return primes;
    }
}
