package arrays.hard.MaximumProductSubArray;

public class Better
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{2, 3, -2, 4};

        int product = findMaximumProduct(nums);

        System.out.println(product);
    }

    private static int findMaximumProduct(int[] nums)
    {
        int maxProduct = 1;
        for(int i = 0 ; i < nums.length ; i++)
        {
            int product = 1;
            for(int j = i ; j < nums.length ; j++)
            {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }

        }
        return maxProduct;
    }
}
