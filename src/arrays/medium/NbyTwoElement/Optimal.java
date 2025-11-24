package arrays.medium.NbyTwoElement;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{2, 2, 1, 1, 1, 1, 1, 2, 2};

        int ans = nByTwo(nums);

        System.out.print(ans);
    }

    private static int nByTwo(int[] nums)
    {
        int element = nums[0];
        int count = 1;

        for(int i = 1 ; i < nums.length ; i++)
        {
            if(count == 0)
            {
                element = nums[i];
                count = 1;
            }
            else if(element == nums[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }


        int count2 = 0;

        for (int num : nums)
        {
            if (num == element)
            {
                count2 += 1;
            }
        }

        if(count2 > nums.length / 2)
                return element;

        return -1;
    }
}
