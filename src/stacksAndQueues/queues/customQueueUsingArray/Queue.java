package stacksAndQueues.queues.customQueueUsingArray;

import java.util.Arrays;

public class Queue<T>
{
    private Object[] queue;
    private static final int DEFAULT_CAPACITY = 8;

    private int start = -1;
    private int end = -1;

    public Queue()
    {
        queue = new Object[DEFAULT_CAPACITY];
    }

    public void push(Object value)
    {
        if(end + 1 == queue.length)
        {
            resizeQueue();
        }

        if(start == -1 && end == -1)
        {
            start = 0;
        }
        queue[++end] = value;

    }

    public void pop()
    {
        if(start == -1) return;

        queue[start] = null;
        start++;

        if(start > end)
        {
            start = -1;
            end = -1;
        }
    }

    public int size()
    {
        return (end - start) + 1;
    }

    @SuppressWarnings("unchecked")
    public T top()
    {
        if(start == -1) return null;

        return (T) queue[start];
    }

    private void resizeQueue()
    {
        queue = Arrays.copyOf(queue, queue.length * 2);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for(int ind = start ; ind <= end ; ind++)
        {
            sb.append(queue[ind]).append(" ");
        }

        return sb.toString();
    }
}
