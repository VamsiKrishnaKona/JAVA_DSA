package DP.strings.LongestCommonSubsequenceLength;

public class Recursive
{
    public static void main(String[] args) {

        String s1 = "acd";
        String s2 = "ced";

        int lcs = findLongestCommonSubsequence(s1, s2);

        System.out.println(lcs);
    }

    private static int findLongestCommonSubsequence(String s1, String s2)
    {
        int len1 = s1.length();
        int len2 = s2.length();

        return solve(len1 - 1, len2 - 1, s1, s2);
    }

    private static int solve(int ind1, int ind2, String s1, String s2)
    {
        //base case
        if(ind1 < 0 || ind2 < 0) return 0;

        //matching
        if(s1.charAt(ind1) == s2.charAt(ind2))
        {
             return 1 + solve(ind1 - 1, ind2 - 1, s1, s2);
        }

        //not matches
        int path1 = solve(ind1 - 1, ind2, s1, s2);
        int path2 = solve(ind1, ind2 - 1, s1, s2);

        return Math.max(path1, path2);
    }

}
