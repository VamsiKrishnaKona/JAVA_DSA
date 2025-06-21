package arrays.hard.MaximumProductSubArray;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{-2, 3, 4, -1, 0, -2, 3, 1, 4, 0, 4, 6, -1, 4};

        int product = findMaximumProduct(nums);

        System.out.println(product);
    }

    private static int findMaximumProduct(int[] nums)
    {
        int maxProduct = 1;
        int prefix = 1;
        int suffix = 1;

        for(int i = 0 ; i <  nums.length ; i++)
        {
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix *= nums[i];
            suffix *= nums[nums.length - 1 - i];

            maxProduct = Math.max(maxProduct, Math.max(suffix, prefix));
        }

        return maxProduct;
    }
}
