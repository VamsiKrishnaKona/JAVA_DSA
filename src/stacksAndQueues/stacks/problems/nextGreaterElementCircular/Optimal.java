package stacksAndQueues.stacks.problems.nextGreaterElementCircular;

import java.util.Arrays;
import java.util.Stack;

public class Optimal
{
    public static void main(String[] args) {

        int[] nums = {2, 10, 12, 1, 11};

        int[] ans = findNextGreaterElements(nums);
        System.out.println(Arrays.toString(ans));
    }

    //T.C = o(4n)
    //S.C = o(2n)
    private static int[] findNextGreaterElements(int[] nums)
    {
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();


        for(int i = (2 * nums.length) - 1 ; i >= 0 ; i--) //2N
        {
            while(!st.isEmpty() && st.peek() <= nums[i % nums.length]) // max 2N
            {
                st.pop();
            }

            if(i < nums.length)
            {
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(nums[i % nums.length]);
        }

        return nge;
    }
}
