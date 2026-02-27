package Bit_Manipulation.intermediate;

public class checkIfNumberIsPowOfTwo
{
    public static void main(String[] args)
    {
        int num = 16;

        boolean ans = check(num);
        System.out.println(ans);
    }

    public static boolean check(int num)
    {
        if((num & num - 1) == 0) return true;
        return false;
    }
}
