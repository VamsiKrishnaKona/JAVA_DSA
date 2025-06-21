package arrays.leetcode;

public class Richest_Customer_Wealth
{

    private static int maximumWealth(int[][] accounts)
    {
        int max = 0;
        for(int person = 0 ; person < accounts.length ; person++)
        {
            int sum = 0;
            for(int account = 0 ; account < accounts[person].length ; account++)
            {
                sum += accounts[person][account];
            }

            if(sum > max)
            {
                max = sum;
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        int[][] arr = new int[][]
                {
                        {1,2,3},
                        {3,2,2}
                };
        int ans = maximumWealth(arr);

        System.out.println(ans);
    }
}
