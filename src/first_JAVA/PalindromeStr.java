package first_JAVA;

import java.util.Scanner;

public class PalindromeStr
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        palindrome(str);
        sc.close();
    }

    static void palindrome(String s)
    {
        int flag = 0;
        for(int i = 0 ; i < s.length()/2 ; i++)
        {
            if(s.charAt(i) != s.charAt(s.length() - i - 1))
            {
                flag = 1;
                break;
            }
        }
        if(flag == 1)
        {
            System.out.println(s +" is the not palindrome.");
        }
        else
        {
            System.out.println(s +" is the palindrome.");
        }
    }
}
