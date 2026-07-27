package stacksAndQueues.stacks.conversions.infixToPostfix;

import java.util.Stack;

public class bruteForce
{
    public static void main(String[] args)
    {
        String str = "a+b*(c^d-e)";
        String ans = infixToPostFix(str);
        System.out.println(ans);
    }

    private static String infixToPostFix(String s)
    {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int i = 0;

        while( i < s.length())
        {
            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9')
            {
                sb.append(ch);
            }
            else if(ch == '(')
            {
                st.push(ch);
            }
            else if(ch == ')')
            {
                while(!st.empty() && st.peek() != '(')
                {
                    sb.append(st.pop());
                }
                st.pop();
            }
            else
            {
                while(!st.empty() &&
                        (priority(ch) < priority(st.peek()) ||
                                (priority(ch) == priority(st.peek()) && ch != '^')))
                {
                    sb.append(st.pop());
                }
                st.push(ch);
            }

            i++;
        }

        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    private static int priority(char ch)
    {
        if(ch == '^') return 3;
        else if(ch == '/' || ch == '*') return 2;
        else if(ch == '+' || ch == '-') return 1;
        else return 0;
    }
}
