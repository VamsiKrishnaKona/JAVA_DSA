package recursion.NumberOfDigitOnes;

public class bruteForce
{
    public static void main(String[] args)
    {
        int n = 100;

        int onesCount = findOnesCount(n);

        System.out.println(onesCount);
    }

    private static int findOnesCount(int num)
    {
        if(num <= 0) return 0;

        long count = findOnesCount(num - 1);

        int n = num;

        while(n != 0)
        {
            int digit = n % 10;
            if(digit == 1) count ++;
            n = n / 10;
        }

        return (int) count;
    }

}
