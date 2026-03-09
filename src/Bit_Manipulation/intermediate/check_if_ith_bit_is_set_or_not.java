package Bit_Manipulation.intermediate;

public class check_if_ith_bit_is_set_or_not
{
    public static void main(String[] args)
    {
        int num = 0;
        int i = 0;

        boolean val = check(num, i);

        System.out.println(val);
    }

    public static boolean check(int num, int i)
    {
        if(i < 0 || i >= Integer.SIZE)
        {
            return false;
        }

        return (num & (1 << i)) != 0;
    }
}
