package Bit_Manipulation.basics;

public class BinaryToInteger
{
    public static void main(String[] args)
    {
        String s = "1111111";

        System.out.println(integer(s));
    }

    public static int integer(String s)
    {
        int ans = 0;
        int pow = 1;

        for(int i = s.length() - 1 ; i >= 0 ; i--)
        {
            if(s.charAt(i) == '1')
            {
                ans = ans + pow;
            }

            pow = pow * 2;
        }
        return ans;
    }
}
