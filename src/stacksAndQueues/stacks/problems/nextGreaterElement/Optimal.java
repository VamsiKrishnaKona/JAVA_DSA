package stacksAndQueues.stacks.problems.nextGreaterElement;

import java.util.Arrays;
import java.util.Stack;

public class Optimal
{
    public static void main(String[] args)
    {
        int[] nums = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};

        int[] nextGreaterElements = findNextGreaterElements(nums);

        System.out.println(Arrays.toString(nextGreaterElements));
    }

    // T.C = o(n * log n)
    // S.C = o(n)
    private static int[] findNextGreaterElements(int[] nums)
    {
        int[] greaterElements = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        for(int i = nums.length - 1; i >= 0; i--)
        {
            if(st.isEmpty() || i == nums.length - 1)
            {
                greaterElements[i] = -1;
                st.push(nums[i]);
            }
            else if(nums[i] < st.peek())
            {
                greaterElements[i] = st.peek();
                st.push(nums[i]);
            }
            else
            {
                while(!st.isEmpty() && st.peek() <= nums[i])
                {
                    st.pop();
                }

                if(!st.isEmpty())
                {
                    greaterElements[i] = st.peek();
                    st.push(nums[i]);
                }
                else
                {
                    greaterElements[i] = -1;
                    st.push(nums[i]);
                }
            }
        }

        return greaterElements;
    }
}
