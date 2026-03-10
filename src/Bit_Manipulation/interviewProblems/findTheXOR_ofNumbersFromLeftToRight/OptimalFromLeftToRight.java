package Bit_Manipulation.interviewProblems.findTheXOR_ofNumbersFromLeftToRight;

public class OptimalFromLeftToRight
{
    public static void main(String[] args)
    {
        int start = 4;
        int end = 7;

        int value = findXORLeftToRight(start, end);
        System.out.println(value);
    }

    private static int findXORLeftToRight(int left, int right)
    {
        int xor1 = findXorUptoN(left - 1);
        int xor2 = findXorUptoN(right);

        return xor1 ^ xor2;
    }

    private static int findXorUptoN(int num)
    {
        if(num % 4 == 1) return 1;
        else if(num % 4 == 2) return num + 1;
        else if(num % 4 == 3) return 0;
        else return num;
    }
}
