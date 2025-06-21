package Strings;

import java.util.HashSet;

public class RemoveDuplicates
{
    public static void main(String[] args) {

        String str = "vamsi krishna";

        removeDuplicates(str);
    }

    public static void removeDuplicates(String str)
    {
        char[] dst = str.toCharArray();

        HashSet<Character> set = new HashSet<>();

        for(int i = 0 ; i < dst.length ; i++)
        {
            set.add(dst[i]);
        }

        System.out.println(set);
    }
}
