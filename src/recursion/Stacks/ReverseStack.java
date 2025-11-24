package recursion.Stacks;

import java.util.Stack;

public class ReverseStack
{
    private static void fixStack(Stack<Integer> st, int val)
    {
        if(st.isEmpty())
        {
            st.push(val);
            return;
        }

        int top = st.pop();

        fixStack(st, val);

        st.push(top);
    }

    private static void reverse(Stack<Integer> st)
    {
        if(st.isEmpty()) return;

        int top = st.pop();

        reverse(st);

        fixStack(st, top);
    }

    public static void main(String[] args)
    {
        Stack<Integer> st = new Stack<>();

        int[] nums = {1, 2, 3, 4, 5};

        for(int i : nums)
        {
            st.push(i);
        }

        System.out.println(st);

        reverse(st);

        System.out.println(st);
    }
}
