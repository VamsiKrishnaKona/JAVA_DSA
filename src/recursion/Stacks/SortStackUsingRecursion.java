package recursion.Stacks;

import java.util.Stack;

public class SortStackUsingRecursion
{
    private static void sortedStack(Stack<Integer> st, int val)
    {
        if(st.isEmpty() || st.peek() <= val)
        {
            st.push(val);
            return;
        }

        int top = st.pop();

        sortedStack(st, val);

        st.push(top);
    }

    private static void sortStack(Stack<Integer> st)
    {
        if(st.isEmpty()) return;

        int top = st.pop();

        sortStack(st);

        sortedStack(st, top);
    }

    public static void main(String[] args)
    {
        Stack<Integer> st = new Stack<>();

        int[] nums = {4, 1, 3, 2};

        for(int i : nums)
        {
            st.push(i);
        }

        System.out.println(st);

        sortStack(st);

        System.out.println(st);
    }
}
