package binarySearch.medium.kokoEatingBananas;

public class Optimal
{
    static int cocoEatingBananas(int[] pile, int hours)
    {
        int minHours = Integer.MAX_VALUE;

        int start = 1;

        int end = max(pile);

        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            int hoursTaken = func(pile, mid);

            if(hoursTaken <= hours)
            {
                minHours = Math.min(minHours, mid);
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }

        return minHours;
    }

    static int max(int[] pile)
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

    public static void main(String[] args)
    {
        int[] pile = {3, 6, 7, 11};
        int hours = 8;

        int ans = cocoEatingBananas(pile, hours);

        System.out.print(ans);
    }
}
