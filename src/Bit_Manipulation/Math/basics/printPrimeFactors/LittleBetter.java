package Bit_Manipulation.Math.basics.printPrimeFactors;

import java.util.ArrayList;
import java.util.List;

public class LittleBetter
{
    public static void main(String[] args)
    {
        int n = 780;
        List<Integer> primeFactors = printPrimeFactors(n);
        System.out.println(primeFactors);
    }

    //o(N) for primeNumber. unpredictable times but less than o(N) for remaining numbers
    private static List<Integer> printPrimeFactors(int num)
    {
        List<Integer> nums = new ArrayList<>();

        for(int i = 2 ; i <= num ; i++)
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
        return nums;
    }
}
