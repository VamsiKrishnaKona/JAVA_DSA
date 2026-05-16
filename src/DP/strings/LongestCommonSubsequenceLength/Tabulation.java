package DP.strings.LongestCommonSubsequenceLength;

public class Tabulation
{
    public static void main(String[] args) {

        String s1 = "acd";
        String s2 = "ced";

        int lcs = longestCommonSubsequence(s1, s2);

        System.out.println(lcs);
    }

    private static int longestCommonSubsequence(String s1, String s2)
    {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int ind1 = 1 ; ind1 <= len1 ; ind1++)
        {
            for(int ind2 = 1 ; ind2 <= len2 ; ind2++)
            {
                //matching
                if(s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                }
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }
        return dp[len1][len2];
    }
}
