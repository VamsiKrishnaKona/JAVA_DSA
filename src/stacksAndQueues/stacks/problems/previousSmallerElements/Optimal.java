package stacksAndQueues.stacks.problems.previousSmallerElements;

import java.util.Arrays;
import java.util.Stack;

public class Optimal
{
    public static void main(String[] args) {

        int[] nums = {4, 5, 2, 10, 8};

        int[] prevSmallerElements = findPrevSmallerElements(nums);
        System.out.println(Arrays.toString(prevSmallerElements));
    }

    //t.c = o(2n)
    //s.c = o(2n)
    private static int[]  findPrevSmallerElements(int[] nums)
    {
        int n = nums.length;
        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n; i++)
        {
            while(!st.isEmpty() && st.peek() >= nums[i])
            {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(nums[i]);
        }

        return pse;
    }
}
