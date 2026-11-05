package slidingWindow_TwoPointers.longestAndSmallestWindow.longestSubStringWith_K_Uniques;

import java.util.HashSet;
import java.util.Set;

public class BruteForce
{
    public static int func(String s, int k)
    {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        for(Character c : s.toCharArray()) set.add(c);

        if(set.size() < k) return -1;

        int maxLen = 0;

        for(int i = 0 ; i < n ; i++)
        {
            set.clear();
            for(int j = i ; j < n ; j++)
            {
                set.add(s.charAt(j));

                if(set.size() <= k)
                {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                else
                {
                    break;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args)
    {
        String s ="tvtgv";
        int k = 4;

        int maxLen = func(s, k);
        System.out.print(maxLen);
    }
}

