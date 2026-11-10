package slidingWindow_TwoPointers.longestAndSmallestWindow.minimumWindowSubSequence;

public class Better
{
    public static void main(String[] args)
    {
        String s1 = "geeksforgeeks";
        String s2 = "eksrg";

        String ans = findMinWindowSubSequence(s1, s2);
        System.out.print(ans);
    }

    private static String findMinWindowSubSequence(String s1, String s2)
    {
        int s1Len = s1.length();
        int s2Len = s2.length();

        int bestStart = -1;
        int bestLen = Integer.MAX_VALUE;

        for(int i = 0 ; i < s1Len ; i++)
        {
            if(s1.charAt(i) == s2.charAt(0))
            {
                int start = i;
                int j = 0;

                while(start < s1Len && j < s2Len && (start - i) < bestLen)
                {
                    if(s1.charAt(start) == s2.charAt(j))
                    {
                        j++;
                    }
                    start++;
                }

                if(j == s2Len && start - i < bestLen)
                {
                    bestLen = start - i;
                    bestStart = i;
                }
            }
        }
        return bestStart == -1 ? "" : s1.substring(bestStart, bestStart + bestLen);
    }
}
