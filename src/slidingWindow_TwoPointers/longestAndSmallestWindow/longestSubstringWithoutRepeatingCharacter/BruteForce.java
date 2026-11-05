package slidingWindow_TwoPointers.longestAndSmallestWindow.longestSubstringWithoutRepeatingCharacter;

import java.util.Arrays;

public class BruteForce
{
    public static void main(String[] args)
    {
        String s = "abcabcdfbb";
        int len = func(s);
        System.out.print(len);
    }

    private static int func(String s)
    {
        int n = s.length();
        int[] hash = new int[256];

        int maxLen = 0;

        for(int i = 0 ; i < n ; i++)
        {
            Arrays.fill(hash, 0);
            int len = 0;
            for(int j = i ; j < n ; j++)
            {
                if(hash[s.charAt(j)] == 0)
                {
                    len++;
                    hash[s.charAt(j)]++;
                }
                else
                {
                    maxLen = Math.max(maxLen, len);
                    break;
                }
            }
        }

        return maxLen;
    }
}
