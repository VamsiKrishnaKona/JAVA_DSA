package arrays.medium.BuyStockAndSell;

public class BruteForce
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{7,1,5,3,6,4};

        int profit = buyStockAndSell(nums);

        System.out.println(profit);
    }

    private static int buyStockAndSell(int[] nums)
    {
        int maxProfit = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            int profit = 0;
            for(int j = i + 1 ; j < nums.length ; j++)
            {
                if(nums[j] > nums[i]) {
                    profit = nums[j] - nums[i];
                    maxProfit = Math.max(maxProfit, profit);
                }
            }
        }

        return maxProfit;
    }
}
