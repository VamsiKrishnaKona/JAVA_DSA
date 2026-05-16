package DP.strings.wildcardMatching;

public class Recursive
{
    public static void main(String[] args) {
        String s1 = "ab*cd";
        String s2 = "abdefcd";

        boolean val = findMatching(s1, s2);

        System.out.println(val);
    }

    private static boolean findMatching(String s1, String s2)
    {
        int l1 = s1.length();
        int l2  = s2.length();

        return solve(l1 - 1, l2 - 1, s1, s2);
    }

    private static boolean solve(int i, int j, String s1, String s2)
    {
        //base
        if(i < 0 && j < 0) return true;

        if(i < 0) return false;

        if(j < 0 && i >= 0)
        {
            for(int k = 0 ; k <= i ; k++) if(s1.charAt(k) != '*') return false;
            return true;
        }


        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?')
        {
            return solve(i - 1, j - 1, s1, s2);
        }

        if(s1.charAt(i) == '*')
        {
            int ind = i - 1;

            boolean one = solve(i - 1, j, s1, s2);
            boolean two = solve(i, j - 1, s1, s2);

            return one | two;
        }
        return false;
    }
}
