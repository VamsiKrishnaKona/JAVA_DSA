package arrays.hard.majorityElementBy3;

import java.util.ArrayList;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] arr = {1, 1, 1, 3, 3, 3, 2, 2};

        ArrayList<Integer> ans = findElements(arr);

        System.out.println(ans);
    }

    private static ArrayList<Integer> findElements(int[] nums)
    {
        int min = (nums.length / 3) + 1;
        ArrayList<Integer> ans = new ArrayList<>();

        if(nums.length == 0)
        {
            return ans;
        }

        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        int count1 = 0;
        int count2 = 0;

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(count1 == 0 && nums[i] != ele2)
            {
                ele1 = nums[i];
                count1 += 1;
            }
            else if(count2 == 0 && nums[i] != ele1)
            {
                ele2 = nums[i];
                count2++;
            }
            else if(nums[i] == ele1)
            {
                count1++;
            }
            else if(nums[i] == ele2)
            {
                count2++;
            }
            else
            {
                count1--;
                count2--;
            }
        }

        int cnt1 = 0, cnt2 = 0;


        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] == ele1) cnt1++;
            if(nums[i] == ele2) cnt2++;
        }

        if(cnt1 >= min) ans.add(ele1);
        if(cnt2 >= min) ans.add(ele2);


        return ans;
    }
}
