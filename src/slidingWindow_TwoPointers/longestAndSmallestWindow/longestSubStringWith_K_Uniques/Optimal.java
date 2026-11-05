package slidingWindow_TwoPointers.longestAndSmallestWindow.longestSubStringWith_K_Uniques;

import java.util.HashMap;
import java.util.Map;

public class Optimal
{
    public static int func(String s, int k)
    {
        int n = s.length();
        int maxLen = 0, r = 0, l = 0;

        Map<Character, Integer> map = new HashMap<>();
        while(r < n)
        {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            if(map.size() > k)
            {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                if(map.get(s.charAt(l)) == 0)
                    map.remove(s.charAt(l));

                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        if(map.size() < k) return -1;
        return maxLen;
    }

    public static void main(String[] args)
    {
        String s ="aabacbebebe";
        int k = 3;

        int maxLen = func(s, k);
        System.out.print(maxLen);
    }
}
