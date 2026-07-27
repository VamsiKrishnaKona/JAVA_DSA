package stacksAndQueues.stacks.problems.balancedParenthesis;

import java.util.Stack;

public class Optimal
{
    public static void main(String[] args) {
        String s = "(";

        boolean value = validParenthesis(s);

        System.out.print(value);
    }

    private static boolean validParenthesis(String s)
    {
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
            {
                st.push(c);
            }
            else {
                if(!st.isEmpty()) return false;

                if(c == ')' && st.peek() == '(')
                {
                    st.pop();
                }
                else if(c == ']' && st.peek() == '[')
                {
                    st.pop();
                }
                else if(c == '}' && st.peek() == '{')
                {
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
