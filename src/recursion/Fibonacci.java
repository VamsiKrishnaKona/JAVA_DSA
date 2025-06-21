package recursion;

public class Fibonacci
{
    public static void main(String [] args)
    {
        int n = 7;
        System.out.println(fibonacci(n));
    }

    static int fibonacci(int n)
    {
        if(n < 2)
        {
            return n;
        }
        return fibonacci(n-2) + fibonacci(n-1);
    }
}
