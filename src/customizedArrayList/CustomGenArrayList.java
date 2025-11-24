package customizedArrayList;

import java.util.Arrays;

public class CustomGenArrayList<T extends Number>
{
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomGenArrayList()
    {
        this.data = new Object[DEFAULT_SIZE];
    }

    private boolean isFull()
    {
        return size == data.length;
    }

    private void resize()
    {
        Object[] temp = new Object[data.length * 2];

        for (int i = 0; i < data.length ; i++)
        {
            temp[i] = data[i];
        }
        data = temp;
    }

    public void add(T value)
    {
        if(isFull())
        {
            resize();
        }

        data[size++] = value;
    }

    public T remove()
    {
        return (T)(data[--size]);
    }

    public T get(int index)
    {
        return (T)(data[index]);
    }

    public int size()
    {
        return size;
    }

    public void set(int index, T value)
    {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomGenArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args)
    {
        CustomGenArrayList<Integer> list = new CustomGenArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);
    }
}
