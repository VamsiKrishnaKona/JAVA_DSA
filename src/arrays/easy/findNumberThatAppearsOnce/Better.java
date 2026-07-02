package arrays.easy.findNumberThatAppearsOnce;

import java.util.HashMap;
import java.util.Map;

public class Better
{
    public static void main(String [] args)
    {
        int[] nums = {1,1,2,2,3,4,4};

        System.out.println(findNumberThatAppearsOnce(nums));
    }

    // T.C = o(N) + o(N)
    // S.C = o(N)
    private static int findNumberThatAppearsOnce(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], value+1);
        }

        for(Map.Entry<Integer, Integer> it : map.entrySet())
        {
            if(it.getValue() == 1)
            {
                return it.getKey();
            }
        }
        return 0;
    }
}
