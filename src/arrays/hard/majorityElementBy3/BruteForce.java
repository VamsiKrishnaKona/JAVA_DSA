package arrays.hard.majorityElementBy3;

import java.util.ArrayList;

public class BruteForce
{
    public static void main(String[] args)
    {
        int[] arr = {1, 1, 1, 3, 3, 2, 2, 2};

        ArrayList<Integer> ans = findElement(arr);

        System.out.println(ans);
    }

    private static ArrayList<Integer> findElement(int[] nums)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        int min = (nums.length / 3) + 1;
        for(int i = 0 ; i < nums.length ; i++)
        {
            int element = nums[i];
            int count = 0;
            for(int j = i ; j < nums.length ; j++)
            {
                if(nums[j] == element)
                    count += 1;
            }

            if(count == min)
                ans.add(element);
        }

        return ans;
    }
}
