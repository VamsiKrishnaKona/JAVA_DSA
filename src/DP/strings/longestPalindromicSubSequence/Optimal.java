package DP.strings.longestPalindromicSubSequence;

public class Optimal
{
    public static void main(String[] args)
    {
        String s = "bbbab";

        int longestPalindromicSubseq = longestPalindromeSubseq(s);
        System.out.println(longestPalindromicSubseq);
    }

    public static int longestPalindromeSubseq(String s)
    {
        String rS = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s, rS);
    }

    public static int longestCommonSubsequence(String s1, String s2)
    {
        int len1 = s1.length();
        int len2 = s2.length();
        int[] prev = new int[len2 + 1];

        for(int ind1 = 1 ; ind1 <= len1 ; ind1++)
        {
            int[] curr = new int[len2 + 1];
            for(int ind2 = 1 ; ind2 <= len2 ; ind2++)
            {
                //matching
                if(s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                {
                    curr[ind2] = 1 + prev[ind2 - 1];
                }
                else
                    curr[ind2] = Math.max(prev[ind2], curr[ind2 - 1]);
            }
            prev = curr;
        }
        return prev[len2];
    }
}
