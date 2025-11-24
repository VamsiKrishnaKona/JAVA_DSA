package loops;

import java.util.Scanner;

public class ReverseString
{
    static String str;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        //reverse(str);
        //reverseUsingArray(str);
        //reverseUsingArrayTwo(str);
        //reverseUsingStringBuffer(str);

    }

    //this method follows extracting the string into characters and add it in reverse way.
    static void reverse(String str)
    {
        char ch;
        String rev = "";
        for(int i = 0 ; i < str.length() ; i++)
        {
            ch = str.charAt(i);
            rev = ch + rev;
        }
        System.out.println(rev);
    }

    //In this method we convert the string to char array using in-built of .toCharArray();
    static void reverseUsingArray(String str)
    {
        char[] arr = str.toCharArray();

        for(int i = str.length()-1 ; i >= 0 ; i--)
        {
            System.out.print(arr[i]);
        }
    }

    // In this method we convert string into character array without using in-built function
    static void reverseUsingArrayTwo(String str)
    {
        char[] arr = new char[str.length()];
        for(int i = 0 ; i < str.length() ; i++)
        {
            arr[i] = str.charAt(i);
            //System.out.print(arr[i]);
        }
        for(int i = arr.length - 1 ; i >= 0 ; i--)
        {
            System.out.print(arr[i]);
        }
    }

    static void reverseUsingStringBuffer(String str)
    {
        StringBuffer strBuf = new StringBuffer(str);
        strBuf.reverse();
        System.out.println(strBuf);
    }
}
