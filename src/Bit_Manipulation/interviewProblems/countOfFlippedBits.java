package Bit_Manipulation.interviewProblems;

public class countOfFlippedBits
{
    public static void main(String[] args)
    {
        int num = 16;
        int goal = 8;

        int ans = findCountOfFlippedBits(num, goal);
        System.out.println(ans);
    }

    private static int findCountOfFlippedBits(int num, int goal)
    {
        int val = num ^ goal;
        return countOfSetBits(val);
    }

    private static int countOfSetBits(int num)
    {
        int count = 0;
        while(num > 0)
        {
            count++;
            num = num & (num - 1);
        }
        return count;
    }
}
