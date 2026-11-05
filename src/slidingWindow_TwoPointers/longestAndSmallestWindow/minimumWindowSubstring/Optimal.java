package slidingWindow_TwoPointers.longestAndSmallestWindow.minimumWindowSubstring;

import java.math.BigDecimal;

public class Optimal
{
    public static void main(String[] args) {

        String s = "cabwefgewcwaefgcf";
        String t = "cae";

        String minLength = findMinWindowString(s, t);
        System.out.print(minLength);
    }

    private static String findMinWindowString(String s, String t)
    {
        int n = s.length();
        int m = t.length();

        BigDecimal val = new BigDecimal(10);
        if(m == 0 || n == 0) return "";

        int l = 0, r = 0;

        int[] hash = new int[256];
        for(int i = 0; i < m; i++) hash[t.charAt(i)]++;
        int count = 0;

        int minLen = Integer.MAX_VALUE;

        int startIdx = -1;

        while(r < n)
        {
            if(hash[s.charAt(r)] > 0) count++;
            hash[s.charAt(r)]--;

            if(count == m)
            {
                if(r - l + 1 < minLen)
                {
                    minLen = r - l + 1;
                    startIdx = l;
                }
            }

            while(count >= m)
            {
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0)
                {
                    if(r - l + 1 < minLen)
                    {
                        minLen = r - l + 1;
                        startIdx = l;
                    }
                    count--;
                }
                l++;
            }
            r++;
        }

        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
