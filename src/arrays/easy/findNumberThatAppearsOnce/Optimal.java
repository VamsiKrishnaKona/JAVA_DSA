package arrays.easy.findNumberThatAppearsOnce;

import java.util.HashMap;
import java.util.Map;

public class Optimal
{
    public static void main(String [] args)
    {
        int[] nums = {1,1,2,2,3,4,4};

        System.out.println(findNumberThatAppearsOnce(nums));
    }

    // T.C = o(N)
    // S.C = o(1)
    private static int findNumberThatAppearsOnce(int[] nums)
    {
        int XOR = 0;

        for(int i : nums)
        {
            XOR = XOR ^ i;
        }
        return XOR;
    }
}
