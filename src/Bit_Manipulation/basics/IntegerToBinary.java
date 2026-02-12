package Bit_Manipulation.basics;

public class IntegerToBinary
{
    public static void main(String[] args) {

        int num = 13;

        System.out.println(binary(num));
    }

    public static String binary(int num)
    {
        String ans = "";

        while(num >= 1)
        {
            ans += num % 2;
            num = num / 2;
        }

        return reverse(ans);
    }

    public static String reverse(String ans)
    {
        String reversed = "";
        for(int i = 0 ; i < ans.length() ; i++)
        {
            reversed = ans.charAt(i) + reversed;
        }

        return reversed;
    }

}
