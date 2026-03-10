package Bit_Manipulation.interviewProblems.findTheXOR_ofNumbersFromLeftToRight;

public class OptimalWithN
{
    public static void main(String[] args)
    {
        int num = 15;
        int xor = findXOR(num);
        System.out.println(xor);
    }

    //T.C : o(1)
    //S.C : o(1)
    private static int findXOR(int num)
    {
        if(num % 4 == 1) return 1;
        else if(num % 4 == 2) return num + 1;
        else if(num % 4 == 3) return 0;
        else return num;
    }
}
