package stacksAndQueues.stacks.problems.minStack.Optimal;

import java.util.Stack;

public class MinStack
{
    private final Stack<Integer> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    public void push(int value)
    {
        if(stack.isEmpty())
        {
            stack.push(value);
            min = Math.min(min, value);
            return;
        }

        if(value >= min)
        {
            stack.push(value);
            return;
        }

        int temp = (2 * value) - min;
        stack.push(temp);

        min = value;
    }

    public void pop()
    {
        if(min >= stack.peek())
        {
            min = (2 * min) - stack.pop();
        }
        else
        {
            stack.pop();
        }
    }

    public int minimum()
    {
        if(stack.isEmpty())
        {
            return -1;
        }
        return min;
    }

    public int peak()
    {
        if(stack.isEmpty())
        {
            return -1;
        }

        if(min > stack.peek())
        {
            return min;
        }

        return stack.peek();
    }

    @Override
    public String toString()
    {
        return stack.toString();
    }
}
