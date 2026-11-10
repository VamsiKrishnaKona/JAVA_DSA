package slidingWindow_TwoPointers.longestAndSmallestWindow.minimumWindowSubSequence;

public class BruteForce
{
    public static void main(String[] args)
    {
        String s1 = "abcdebdde";
        String s2 = "bde";

        String ans = findMinWindowSubSequence(s1, s2);
        System.out.print(ans);
    }

    private static String findMinWindowSubSequence(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();

        int bestStart = -1;
        int bestLen = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i ; j < n ; j++)
            {
                if(isValid(s1, s2, i, j, n, m))
                {
                    int len = j - i + 1;
                    if(len < bestLen)
                    {
                        bestLen =len;
                        bestStart = i;
                    }
                    break;
                }
            }
        }
        return bestStart == -1 ? "" : s1.substring(bestStart, bestStart + bestLen);
    }

    private static boolean isValid(String s1, String s2, int low, int high, int n, int m)
    {
        int j = 0;
        for(int i = low ; i <= high && j < m ; i++)
        {
           if(s1.charAt(i) == s2.charAt(j))
           {
               j++;
           }
        }

        return j == m;
    }
}
