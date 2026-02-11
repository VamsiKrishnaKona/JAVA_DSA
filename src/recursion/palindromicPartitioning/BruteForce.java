package recursion.palindromicPartitioning;

import java.util.ArrayList;
import java.util.List;

public class BruteForce
{
    public static void main(String[] args)
    {
        String s = "aab";

        List<List<String>> palindromes = partition(s);

        for(List<String> list : palindromes)
        {
            System.out.println(list);
        }
    }

    public static List<List<String>> partition(String s)
    {
        List<List<String>> poss = new ArrayList<>();
        List<String> validSubs = new ArrayList<>();
        solve(s, poss, validSubs);

        return poss;
    }

    public static void solve(String s, List<List<String>> poss, List<String> validSubs)
    {
        if(s == null || s.isEmpty() || s.length() == 0)
        {
            poss.add(new ArrayList<>(validSubs));
            return;
        }

        for(int i = 0 ; i < s.length() ; i++)
        {
            String sub = s.substring(0, i + 1);
            if(isValidPalindrome(sub))
            {
                validSubs.add(sub);
                String remStr = s.substring(i + 1, s.length());
                solve(remStr, poss, validSubs);
                validSubs.remove(validSubs.size() - 1);
            }
        }
    }

    private static boolean isValidPalindrome(String s)
    {
        int left = 0, right = s.length() - 1;

        while (left < right)
        {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
