package Bit_Manipulation.interviewProblems;

public class FindTheDifference
{
    public static void main(String[] args) {
        String a = "abcd";
        String b = "abcde";

        char diff = findTheDifference(a, b);

        System.out.println(diff);
    }

    public static char findTheDifference(String s, String t)
    {
        char result = 0;
        for(int i = 0 ; i < t.length() ; i++)
        {
            if(i < s.length())
            {
                result ^= s.charAt(i);
            }
            result ^= t.charAt(i);
        }

        return result;
    }
}
