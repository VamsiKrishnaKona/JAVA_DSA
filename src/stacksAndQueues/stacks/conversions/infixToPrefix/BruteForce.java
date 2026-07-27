package stacksAndQueues.stacks.conversions.infixToPrefix;

import java.util.Stack;

public class BruteForce
{
    public static void main(String[] args)
    {
        String str = "F+D-C*(B+A)";
        String ans = infixToPrefix(str);
        System.out.println(ans);
    }

    private static String infixToPrefix(String s)
    {
        if(s.length() == 0) return "";

        s = reverse(s);

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int i = 0;

        while( i < s.length())
        {
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch))
            {
                sb.append(ch);
            }
            else if(ch == '(')
            {
                stack.push(ch);
            }
            else if(ch == ')')
            {
                while(!stack.empty() && stack.peek() != '(')
                {
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else
            {
                while (!stack.isEmpty() &&
                        (priority(ch) < priority(stack.peek()) ||
                                (priority(ch) == priority(stack.peek()) && ch == '^')))
                {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
            i++;
        }

        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private static int priority(char ch)
    {
        if(ch == '^') return 3;
        else if(ch == '/' || ch == '*') return 2;
        else if(ch == '+' || ch == '-') return 1;
        else return -1;
    }

    private static String reverse(String str)
    {
        StringBuilder sb = new StringBuilder();

        for(int i = str.length() - 1; i >= 0; i--)
        {
            if(str.charAt(i) == '(')
            {
                sb.append(')');
            }
            else if(str.charAt(i) == ')')
            {
                sb.append('(');
            }
            else
            {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
