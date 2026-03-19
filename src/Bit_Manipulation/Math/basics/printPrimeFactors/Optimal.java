package Bit_Manipulation.Math.basics.printPrimeFactors;

import java.util.ArrayList;
import java.util.List;

public class Optimal
{
    public static void main(String[] args)
    {
        int n = 780;
        List<Integer> primeFactors = printPrimeFactors(n);
        System.out.println(primeFactors);
    }

    //T.C = o(log N)
    private static List<Integer> printPrimeFactors(int num)
    {
        List<Integer> nums = new ArrayList<>();

        for(int i = 2 ; i <= Math.sqrt(num) ; i++)
        {
            if(num % i == 0)
            {
                nums.add(i);
                while(num % i == 0)
                {
                    num = num / i;
                }
            }
        }

        if(num != 1) nums.add(num);
        return nums;
    }
}
