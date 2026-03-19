package Bit_Manipulation.Math.basics.printAllDivisors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Optimal
{
    public static void main(String[] args)
    {
        int num = 36;
        List<Integer> divisors = printDivisors(num);

        System.out.println(divisors);
    }

    private static List<Integer> printDivisors(int num)
    {
        List<Integer> divisors = new ArrayList<>();

        for(int i = 1 ; i <= Math.sqrt(num) ; i++)
        {
            if(num % i == 0)
            {
                divisors.add(i);
                if(num / i != i) divisors.add(num / i);
            }
        }

        Collections.sort(divisors);

        return divisors;
    }
}
