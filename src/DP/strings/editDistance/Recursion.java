package DP.strings.editDistance;

public class Recursion
{
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        int mini = minimumOperations(s1, s2);

        System.out.println(mini);
    }

    private static int  minimumOperations(String s1, String s2)
    {
        int l1 =  s1.length();
        int l2 = s2.length();

        return solve(l1 - 1, l2 - 1, s1, s2);
    }

    private static int solve(int i, int j, String s1, String s2)
    {
        //base

        //if s1 ended, adding s2 upto j + 1;
        if(i < 0) return j + 1;

        //if s2 ended, deleting s1 upto i + 1;
        if(j < 0) return i + 1;

        //changing
        if(s1.charAt(i) == s2.charAt(j))
        {
            return solve(i - 1, j - 1, s1, s2);
        }

        int insertion = 1 + solve(i, j - 1, s1, s2);
        int deletion = 1 + solve(i - 1, j, s1, s2);
        int replace = 1 + solve(i - 1, j - 1, s1, s2);

        return Math.min(insertion, Math.min(deletion, replace));
    }
}
