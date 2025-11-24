package arrays.hard.majorityElementBy3;

import java.util.ArrayList;
import java.util.HashMap;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> origin/krishna

public class Better
{
    public static void main(String[] args)
    {
        int[] arr = {1, 1, 1, 3, 3, 2, 2, 2};

        ArrayList<Integer> ans = findElement(arr);

        System.out.println(ans);
    }

    private static ArrayList<Integer> findElement(int[] nums)
    {
        int min = (nums.length/3) + 1;

        HashMap<Integer, Integer> mp = new HashMap<>();

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0  ; i < nums.length ; i++)
        {
            int value = mp.getOrDefault(nums[i], 0);
            mp.put(nums[i], value + 1);

            if(mp.get(nums[i]) == min)
                ans.add(nums[i]);
        }

        return ans;
    }
}
