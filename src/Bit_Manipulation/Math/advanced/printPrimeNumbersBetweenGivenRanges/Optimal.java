package Bit_Manipulation.Math.advanced.printPrimeNumbersBetweenGivenRanges;

import java.util.Arrays;

public class Optimal
{
    //10^6
    private static final int MAX = 1000000;
    private static int[] isPrime = new int[MAX + 1];
    private static int[] prefix = new int[MAX + 1];

    public static void main(String[] args)
    {
        int[][] queries = {
                {1, 10},
                {10, 50},
                {100, 200}
        };

        printPrimes(queries);
    }

    private static void printPrimes(int[][] queries)
    {
        buildSieve();
        buildPrefix();

        for(int[] query : queries)
        {
            int L = query[0];
            int R = query[1];

            System.out.println(primeCount(L, R));
        }
    }

    private static void buildSieve()
    {
        Arrays.fill(isPrime, 1);

        isPrime[0] = 0;
        isPrime[1] = 0;

        for(int i = 2 ; i * i <= MAX ; i++)
        {
            if(isPrime[i] == 1)
            {
                for(int j = i * i ; j <= MAX ; j += i)
                {
                    isPrime[j] = 0;
                }
            }
        }
    }

    private static void buildPrefix()
    {
        int count = 0;
        for(int i = 0 ; i <= MAX ; i++)
        {
            if(isPrime[i] == 1)
            {
                count++;
            }
            prefix[i] = count;
        }
    }

    private static int primeCount(int left, int right)
    {
        if(left == 0) return prefix[right];
        return prefix[right] - prefix[left - 1];
    }

}
