package Bit_Manipulation.Math.advanced.SmallestPrimeFactor;

public class Optimal
{
    //10^5
    private static final int max = 100000;
    private static final int[] spf = new int[max + 1];

    public static void main(String[] args)
    {
        int[] queries = {10, 20, 30};

        printPrimeFactorisation(queries);
    }

    private static void  printPrimeFactorisation(int[] queries)
    {
        buildSieve();
        for(int i = 0 ; i < queries.length; i++)
        {
            int num = queries[i];

            System.out.print(num + " -> ");
            while(num != 1)
            {
                System.out.print(spf[num] + " ");
                num = num / spf[num];
            }
            System.out.println();
        }
    }

    private static void buildSieve()
    {
        for(int i = 0 ; i < spf.length; i++) spf[i] = i;

        for(int i = 2 ; i * i <= max ; i++)
        {
            if(spf[i] == i)
            {
                for(int j = i * i ; j <= max ; j += i)
                {
                    if(spf[j] == j)
                    {
                        spf[j] = i;
                    }
                }
            }
        }
    }
}
