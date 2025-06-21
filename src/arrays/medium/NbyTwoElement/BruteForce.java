package arrays.medium.NbyTwoElement;

public class BruteForce
{
    private static int nByTwo(int[] nums)
    {
        int n = nums.length;

        for(int i = 0 ; i < n ; i++)
        {
            int element = nums[i];
            int count = 0;
            for(int j = 0 ; j < n ; j++)
            {
                if(nums[j] == element)
                {
                    count++;
                }
            }

            if(count > n / 2)
                return element;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{2, 2, 1, 1, 1, 1, 1, 2, 2};

        int ans = nByTwo(nums);

        System.out.print(ans);
    }
}
