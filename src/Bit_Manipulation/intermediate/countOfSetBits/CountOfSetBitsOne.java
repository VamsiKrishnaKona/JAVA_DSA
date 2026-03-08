package Bit_Manipulation.intermediate.countOfSetBits;

public class CountOfSetBitsOne
{
    public static void main(String[] args)
    {
        int n = 15;
        int count = findCount(n);
        System.out.println(count);
    }

    private static int findCount(int num)
    {
        int count = 0;

        while(num > 0)
        {
            count += (num & 1);
            num = num >> 1;
        }
        return count;
    }
}
