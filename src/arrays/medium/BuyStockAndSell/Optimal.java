package arrays.medium.BuyStockAndSell;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{7,1,5,3,10,4};

        int profit = buyStockAndSell(nums);

        System.out.println(profit);
    }

    private static int buyStockAndSell(int[] nums)
    {
        int maxProfit = 0;

        int buy = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] < buy)
                buy = nums[i];

            int profit = nums[i] - buy;

            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
