package loops;

import java.util.Scanner;

public class PalindromeStr
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        //palindrome(s);
        palindrome2(s);

    }

    private static void palindrome2(String s)
    {
        int flag = 0;
        for(int i = 0 ; i <= s.length()/2 ; i++)
        {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i))
            {
                flag = 1;
                break;
            }
        }

        if(flag == 0)
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
    }

    public static void palindrome(String s)
    {
        //String og = s;
        String rev = "";
        for(int i = (s.length() - 1) ; i >= 0 ; i--)
        {
            rev = rev + s.charAt(i);
        }

        if(rev.equals(s))
        {
            System.out.println("true");
        }
        else {
        System.out.println("false");
        }


    }
}
