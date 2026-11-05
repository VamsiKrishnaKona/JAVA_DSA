package slidingWindow_TwoPointers.longestAndSmallestWindow.minimumWindowSubstring;

public class BruteForce
{
    public static void main(String[] args) {

        String s = "A";
        String t = "AA";

        String minLength = findMinWindowString(s, t);
        System.out.print(minLength);
    }

    private static String findMinWindowString(String s, String t)
    {
        int n = s.length();
        int m = t.length();

        int minLen = Integer.MAX_VALUE;

        int startIdx = -1;

        for(int i = 0 ; i < n ; i++)
        {
            int count = 0;
            int[] hash = new int[256];
            for(int idx = 0 ; idx < m ; idx++) hash[t.charAt(idx)]++;

            for(int j = i ; j < n ; j++)
            {
                if(hash[s.charAt(j)] > 0)
                {
                    count++;
                }

                hash[s.charAt(j)]--;

                if(count == m)
                {
                    if((j - i) + 1 < minLen)
                    {
                        minLen = j - i + 1;
                        startIdx = i;
                        break;
                    }
                }
            }
        }

        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
