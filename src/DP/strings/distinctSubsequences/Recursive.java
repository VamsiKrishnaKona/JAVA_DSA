package DP.strings.distinctSubsequences;

public class Recursive
{
    public static void main(String[] args)
    {
        String s1 = "babgbag";
        String s2 = "bag";

        int ans = distinctSubSeq(s1, s2);
        System.out.println(ans);
    }

    private static int distinctSubSeq(String s1, String s2)
    {
        int len1 = s1.length();
        int len2 = s2.length();

        return solve(len1 - 1, len2 - 1, s1, s2);
    }

    private static int solve(int i, int j, String s1, String s2)
    {
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(s1.charAt(i) == s2.charAt(j))
        {
            return (solve(i - 1, j - 1, s1, s2) + solve(i - 1, j, s1, s2));
        }

        return solve(i - 1, j, s1, s2);
    }
}
