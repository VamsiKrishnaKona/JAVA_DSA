package DP.strings.distinctSubsequences;

public class Optimal
{
    public static void main(String[] args)
    {
        String s1 = "babgbag";
        String s2 = "bag";

        int ans = distinctSubSeq(s1, s2);
        System.out.println(ans);
    }

    private static int distinctSubSeq(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[] prev = new int[len2 + 1];
        int[] curr = new int[len2 + 1];

        prev[0] = 1;
        curr[0] = 1;

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j]; //(solve(i - 1, j - 1, s1, s2, dp) + solve(i - 1, j, s1, s2, dp));
                } else {
                    curr[j] = prev[j];  //solve(i - 1, j, s1, s2, dp);
                }
            }
            prev = curr;
        }
        return curr[len2];
    }
}
