package DP.strings.LongestCommonSubsequence;

public class Tabulation
{
    public static void main(String[] args)
    {
        String s1 = "abac";
        String s2 = "cab";

        String lcs = longestCommonSubsequence(s1, s2);

        System.out.println(lcs);
    }

    private static String longestCommonSubsequence(String s1, String s2)
    {
        int len1 = s1.length();
        int len2 = s2.length();
        String[][] dp = new String[len1 + 1][len2 + 1];

        for(int i = 0 ; i <= len1 ; i++) dp[i][0] = "";
        for(int j= 0 ; j <= len2 ; j++) dp[0][j] = "";

        for(int ind1 = 1 ; ind1 <= len1 ; ind1++)
        {
            for(int ind2 = 1 ; ind2 <= len2 ; ind2++)
            {
                //matching
                if(s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                {
                    dp[ind1][ind2] = dp[ind1 - 1][ind2 - 1] + s1.charAt(ind1 - 1);
                }
                else {

                    int l1 = dp[ind1 - 1][ind2].length();
                    int l2 = dp[ind1][ind2 - 1].length();

                    if(l1 > l2) dp[ind1][ind2] = dp[ind1 - 1][ind2];
                    else dp[ind1][ind2] = dp[ind1][ind2 - 1];
                }
            }
        }
        return dp[len1][len2];
    }
}
