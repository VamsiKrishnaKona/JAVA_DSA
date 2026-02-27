package Bit_Manipulation.intermediate;

public class set_The_ith_bit
{
    public static void main(String[] args)
    {
        int num = 9;
        int i = 2;

        int ans = setBit(num, i);

        System.out.println(ans);
    }

    public static int setBit(int num, int i)
    {
        return num = (num) | (1 << i);
    }
}
