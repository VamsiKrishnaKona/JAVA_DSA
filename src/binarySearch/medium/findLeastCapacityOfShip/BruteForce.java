package binarySearch.medium.findLeastCapacityOfShip;

public class BruteForce
{
    private static int func(int[] nums, int weighCapacity)
    {
        int load = 0;
        int day = 1;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(load + nums[i] > weighCapacity)
            {
                day += 1;
                load = nums[i];
            }
            else
            {
                load += nums[i];
            }
        }

        return day;
    }

    private static int findLeastCapacity(int[] nums, int days)
    {
        int minCapacity = max(nums);

        int maxCapacity = sumOfWeights(nums);

        for(int i = minCapacity ; i <= maxCapacity ; i++)
        {
            int daysTaken = func(nums, i);

            if(daysTaken <= days) return i;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] weights = new int[]{1, 2, 3, 4, 5, 6 ,7, 8, 9, 10};
        int days = 5;

        int leastWeightCapacity = findLeastCapacity(weights, days);

        System.out.print(leastWeightCapacity);
    }

    private static int max(int[] nums)
    {
        int max = Integer.MIN_VALUE;

        for(int i : nums)
        {
            max = Math.max(max, i);
        }
        return max;
    }

    private static int sumOfWeights(int[] nums)
    {
        int sum = 0;

        for(int i : nums)
        {
            sum += i;
        }
        return sum;
    }
}
