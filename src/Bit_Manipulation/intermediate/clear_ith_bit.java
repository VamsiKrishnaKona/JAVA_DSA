package Bit_Manipulation.intermediate;

public class clear_ith_bit
{
    public static void main(String[] args)
    {
        int num = 13;
        int i = 2;

        int ans = clear(num, i);
        System.out.println(ans);
    }

    public static int clear(int num, int i)
    {
        return num & (~(1 << i));
    }
}
