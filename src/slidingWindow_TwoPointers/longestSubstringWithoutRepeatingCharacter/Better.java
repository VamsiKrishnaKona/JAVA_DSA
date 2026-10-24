package slidingWindow_TwoPointers.longestSubstringWithoutRepeatingCharacter;

import java.util.HashMap;
import java.util.Map;

public class Better
{
    public static void main(String[] args)
    {
        String s = "mq";
        int longestLen = findLongestSubstringLenWithoutCharacters(s);

        System.out.print(longestLen);
    }

    private static int  findLongestSubstringLenWithoutCharacters(String s)
    {
        int maxLen = 0;
        int l = 0, r = 0;

        Map<Character, Integer> map = new HashMap<>();

        while(r < s.length())
        {
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) >= l)
            {
                l = l + map.get(s.charAt(r)) + 1;
                map.put(s.charAt(r), r);
            }
            else
            {
                map.put(s.charAt(r), r);
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
