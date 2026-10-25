package slidingWindow_TwoPointers.numberofSubstringsContainingAllThreeCharacters;

import java.util.Arrays;

public class Optimal
{
    public static void main(String[] args)
    {
        String s = "aaabc";
        int noOfSubstrings = findNumberOfSubStrings(s);
        System.out.print(noOfSubstrings);
    }

    private static int findNumberOfSubStrings(String s)
    {
        int count = 0;
        int n  = s.length();
        int r = 0;

        int[] hash = new int[3];
        Arrays.fill(hash, -1);

        while (r < n)
        {
            hash[s.charAt(r) - 'a'] = r;

            if(hash[0] != -1 && hash[1] != -1 && hash[2] != -1)
            {
                int minIdx = Math.min(hash[0], Math.min(hash[1], hash[2]));
                count += minIdx + 1;
            }
            r++;
        }
        return count;
    }
}
