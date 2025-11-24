package binarySearch.medium.kokoEatingBananas;

public class BruteForce
{
    static int maxx(int[] pile)
    {
        int max = -1;
        for(int i = 0 ; i < pile.length - 1 ; i++)
        {
            if(pile[i] > max) max = pile[i];
        }
        return max;
    }

    static int func(int[] pile, int iteration)
    {
        int hoursTaken = 0;

        for(int i = 0 ; i < pile.length ; i++)
        {
            //hoursTaken += (int) Math.ceil((double)pile[i] / iteration);
            hoursTaken += (pile[i] + iteration - 1) / iteration;
        }
        return hoursTaken;
    }

    static int bruteForce(int[] pile, int hours)
    {
        int k = 1;

        int maxInPile = maxx(pile);
        for(int i = 1 ; i <= maxInPile ; i++)
        {
            int hoursEaten = func(pile, i);

            if(hoursEaten <= 8) return i;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] pile = {3, 6, 7, 11};
        int hours = 8;

        int ans = bruteForce(pile, hours);

        System.out.print(ans);
    }
}
