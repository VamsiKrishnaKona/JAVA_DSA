package Bit_Manipulation.Math.basics.printAllDivisors;

public class Naive
{
    public static void main(String[] args)
    {
        int num = 36;
        printDivisors(num);
    }

    private static void printDivisors(int num)
    {
        for(int i = 1 ; i <= num ; i++)
        {
            if(num % i == 0) System.out.println(i);
        }
    }
}
