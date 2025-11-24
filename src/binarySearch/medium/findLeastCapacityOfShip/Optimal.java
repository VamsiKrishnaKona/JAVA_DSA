package binarySearch.medium.findLeastCapacityOfShip;

public class Optimal
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
        int start = max(nums);

        int end = sumOfWeights(nums);

        int leastWeight = Integer.MAX_VALUE;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            int daysTaken = func(nums, mid);

            if(daysTaken <= days)
            {
                end = mid - 1;
                leastWeight = Math.min(leastWeight, mid);
            }
            else
            {
                start = mid + 1;
            }

        }
        return leastWeight;
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
