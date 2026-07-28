package DP.MCM.burstBalloons;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Recursive
{
    public static void main(String[] args)
    {
        int[] nums = {3,1,5,8};
        int ans = maxCoins(nums);
        System.out.println(ans);
    }

    public static int maxCoins(int[] nums)
    {
        int len = nums.length;
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        numbers.add(0, 1);
        numbers.add(numbers.size(), 1);
        return solve(1, len, numbers);
    }

    public static int solve(int i, int j, List<Integer> nums)
    {
        if(i > j) return 0;

        int maxi = Integer.MIN_VALUE;
        for(int ind = i ; ind <= j ; ind++)
        {
            int value = nums.get(i - 1) * nums.get(ind) * nums.get(j + 1)
                    + solve(i, ind - 1, nums) + solve(ind + 1, j, nums);

            maxi = Math.max(maxi, value);
        }
        return maxi;
    }
}
