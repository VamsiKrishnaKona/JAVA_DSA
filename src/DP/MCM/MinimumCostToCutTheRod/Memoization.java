package DP.MCM.MinimumCostToCutTheRod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Memoization
{
    public static void main(String[] args)
    {
        int rodLen = 7;
        int[] cuts = {1, 3, 4, 5};

        int cost = findMinimumCost(rodLen, cuts);
        System.out.println(cost);
    }

    private static int  findMinimumCost(int rodLen, int[] cuts)
    {
        int cutsLen = cuts.length;
        List<Integer> nums = new ArrayList<>(Arrays.stream(cuts).boxed().toList()); // {1, 3, 4, 5}
        nums.addFirst(0);
        nums.addLast(rodLen);
        Collections.sort(nums);
        // {0, 1, 3, 4, 5, 7}
        int[][] dp = new int[nums.size()][nums.size()];
        return solve(1, cutsLen, nums, dp);
    }

    private static int solve(int i, int j, List<Integer> cuts, int[][] dp)
    {
        if(i > j)
        {
            return 0;
        }

        if(dp[i][j] != 0) return dp[i][j];
        int minCost = Integer.MAX_VALUE;

        for(int ind = i ; ind <= j ; ind++)
        {
            int cost = cuts.get(j + 1) - cuts.get(i - 1)
                    + solve(i, ind - 1, cuts, dp)
                    + solve(ind + 1, j, cuts, dp);

            minCost = Math.min(minCost, cost);
        }
        return dp[i][j] = minCost;
    }
}
