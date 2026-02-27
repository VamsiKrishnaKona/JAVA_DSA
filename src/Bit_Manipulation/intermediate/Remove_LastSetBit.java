package Bit_Manipulation.intermediate;

public class Remove_LastSetBit
{
    public static void main(String[] args)
    {
        int num = 13;

        int ans = removeLastSetBit(num);
        System.out.println(ans);
    }

    public static int removeLastSetBit(int num)
    {
        return num & (num - 1);
    }

}
