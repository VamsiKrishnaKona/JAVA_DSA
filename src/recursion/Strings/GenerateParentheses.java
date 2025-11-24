package recursion.Strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses
{

    public static void generateParentheses(int n, int openCount, int closeCount, String s, List<String> possibilities)
    {
        if(s.length() == 2 * n)
        {
            possibilities.add(s);
            return;
        }

//        if(s.isEmpty())
//        {
//            generateParentheses(n, openCount + 1, closeCount, s + '(', possibilities);
//        }
//
//        if(closeCount == openCount && openCount < n)
//        {
//            generateParentheses(n, openCount + 1, closeCount, s + '(', possibilities);
//        }
//
//        if(closeCount < openCount && openCount < n)
//        {
//            generateParentheses(n, openCount + 1, closeCount, s + '(', possibilities);
//            generateParentheses(n, openCount, closeCount + 1, s + ')', possibilities);
//        }
//
//        if(closeCount < openCount && openCount == n)
//        {
//            generateParentheses(n, openCount, closeCount + 1, s + ')', possibilities);
//        }

        if(openCount < n) generateParentheses(n, openCount + 1, closeCount, s + '(', possibilities);
        if(closeCount < openCount) generateParentheses(n, openCount, closeCount + 1, s + ')', possibilities);
    }
    public static void printParentheses(int n)
    {
        int openCount = 0;
        int closeCount = 0;

        String s = "";
        List<String> strings = new ArrayList<>();

        generateParentheses(n, openCount, closeCount, s, strings);

        System.out.println(strings);
    }

    public static void main(String[] args)
    {
        int n = 3;

        printParentheses(n);
    }
}
