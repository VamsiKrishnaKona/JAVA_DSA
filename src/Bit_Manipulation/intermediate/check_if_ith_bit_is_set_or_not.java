package Bit_Manipulation.intermediate;

import Bit_Manipulation.basics.IntegerToBinary;

public class check_if_ith_bit_is_set_or_not
{
    public static void main(String[] args)
    {
        int num = 13;
        int i = 1;

        boolean val = check(num, i);

        System.out.println(val);
    }

    public static boolean check(int num, int i)
    {
        num = num >> i;
        String binary = IntegerToBinary.binary(num);

        if(binary.charAt(binary.length() - 1) == '1')
        {
            return true;
        }

        return false;
    }
}
