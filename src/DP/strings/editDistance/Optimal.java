package DP.strings.editDistance;

public class Optimal
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
        int[] prev = new int[l2 + 1];

        for(int j = 0 ; j <= l2 ; j++) prev[j] = j;

        for(int i = 1; i <= l1; i++)
        {
            int[] curr = new int[l2 + 1];
            curr[0] = i;
            for(int j = 1 ; j <= l2 ; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    curr[j] =  prev[j - 1]; //solve(i - 1, j - 1, s1, s2, dp);
                }
                else {
                    int insertion = 1 + curr[j - 1]; //solve(i, j - 1, s1, s2, dp);
                    int deletion = 1 + prev[j]; //solve(i - 1, j, s1, s2, dp);
                    int replace = 1 + prev[j - 1]; //solve(i - 1, j - 1, s1, s2, dp);

                    curr[j] = Math.min(insertion, Math.min(deletion, replace));

                }
            }
            prev = curr;
        }

        return prev[l2]; //solve(l1 - 1, l2 - 1, s1, s2, dp);
    }
}
