package DP.strings.shortestSuperSequence.shortestSuperSeqString;

public class Tabulation
{
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";

        String ans = longestCommonSubsequence(s1, s2);
        System.out.println(ans);
    }

    private static String longestCommonSubsequence(String s1, String s2)
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

        int i = len1;
        int j = len2;
        StringBuilder ans = new StringBuilder();
        while(i > 0 && j > 0)
        {
            if(s1.charAt(i - 1) == s2.charAt(j - 1))
            {
                ans.append(s1.charAt(i - 1));
                i--;
                j--;
            }
            else if(dp[i - 1][j] > dp[i][j - 1])
            {
                ans.append(s1.charAt(i - 1));
                i--;
            }
            else
            {
                ans.append(s2.charAt(j - 1));
                j--;
            }
        }

        if(i > 0)
        {
            ans.append(s1.charAt(i - 1));
            i--;
        }

        if(j > 0)
        {
            ans.append(s2.charAt(j - 1));
            j--;
        }



        return ans.reverse().toString();
    }
}
