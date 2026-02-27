package Bit_Manipulation.intermediate;

public class Toggle_ith_bit
{
    public static void main(String[] args)
    {
        int num = 13;
        int i = 2;

        int ans = toggle(num, i);
        System.out.println(ans);
    }

    public static int toggle(int num, int i)
    {
        return num ^ (1 << i);
    }
}
