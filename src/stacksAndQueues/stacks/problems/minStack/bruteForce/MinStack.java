package stacksAndQueues.stacks.problems.minStack.bruteForce;

import java.util.Stack;

public class MinStack
{
    private final Stack<Pair<Integer,Integer>> stack = new Stack<>();

    public void push(int number)
    {
        if(stack.isEmpty())
        {
            stack.push(new Pair<>(number,number));
            return;
        }

        stack.push(new Pair<>(number, Math.min(number, stack.peek().value() )));
    }

    public Object pop()
    {
        if(stack.isEmpty())
        {
            return null;
        }
        return stack.pop();
    }

    public Object peek()
    {
        if(stack.isEmpty())
        {
            return null;
        }
        return stack.peek();
    }

    public String toString()
    {
        return stack.toString();
    }

    public Object min()
    {
        if(stack.isEmpty())
        {
            return null;
        }

        return stack.peek().value();
    }

    public static void main(String[] args)
    {
        MinStack minStack = new MinStack();

        minStack.push(12);
        minStack.push(13);
        minStack.push(14);
        minStack.push(10);

        System.out.println(minStack);
        System.out.println(minStack.min());

        minStack.pop();

        System.out.println(minStack);
        System.out.println(minStack.min());
    }
}
