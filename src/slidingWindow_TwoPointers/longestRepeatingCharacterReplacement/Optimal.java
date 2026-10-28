package slidingWindow_TwoPointers.longestRepeatingCharacterReplacement;

import java.util.HashMap;
import java.util.Map;

public class Optimal
{
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        int maxLen = findLongestSubstring(s, k);
        System.out.print(maxLen);
    }

    private static int findLongestSubstring(String s, int k)
    {
        int n = s.length();
        int l = 0, r = 0;
        int maxLen = 0;
        int maxFreq = 0;

        Map<Character, Integer> map = new HashMap<>();

        while(r < n)
        {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));

            if((r - l + 1) - maxFreq > k)
            {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                if(map.get(s.charAt(l)) <= 0) map.remove(s.charAt(l));
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
