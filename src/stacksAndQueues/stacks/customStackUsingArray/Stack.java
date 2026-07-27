package stacksAndQueues.stacks.customStackUsingArray;


import java.util.Arrays;

public class Stack<T>
{
    private int top = -1;
    private Object[] stack;
    private static final int DEFAULT_CAPACITY = 10;


    public Stack()
    {
        this.stack = new Object[DEFAULT_CAPACITY];
    }

    private boolean isFull()
    {
        return top + 1 == stack.length;
    }

    public void push(T value)
    {
        if(isFull())
        {
            updateStackSize();
        }

        stack[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T top()
    {
        if(top == -1) return null;

        return (T) stack[top];
    }

    public void pop()
    {
        if(isEmpty()) return;
        stack[top--] = null;
    }

    public int size()
    {
        return top + 1;
    }

    public void add(int index, T value)
    {
        if(isFull())
        {
            updateStackSize();
        }

        System.arraycopy(stack, index, stack, index + 1, top - index + 1);
        stack[index] = value;
        top++;
    }

    private void updateStackSize()
    {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    private boolean isEmpty()
    {
        return top == -1;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <= top ; i++)
        {
            sb.append(stack[i].toString()).append(" ");
        }
        return sb.toString();
    }
}
