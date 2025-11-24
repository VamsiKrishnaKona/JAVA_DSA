package Strings;

public class ReverseString
{
    public static void main(String [] args)
    {
        String s = "vamsi krishna";

        reverse(s);
    }

    public static void reverse(String s)
    {
        char c;
        String rev = "";

        for(int i = 0 ; i < s.length() ; i++)
        {
            c = s.charAt(i);
            rev = (c + rev);
        }
        System.out.println(rev);

    }
}
