package slidingWindow_TwoPointers.numberofSubstringsContainingAllThreeCharacters;

public class OptimizedBruteForce
{
    public static void main(String[] args)
    {
        String s = "abcabc";
        int noOfSubstrings = findNumberOfSubStrings(s);
        System.out.print(noOfSubstrings);
    }

    private static int findNumberOfSubStrings(String s)
    {
        int count = 0;
        int n  = s.length();

        for(int i = 0 ; i < n ; i++)
        {
            int[] hash = new int[3];
            for(int j = i ; j < n ; j++)
            {
                hash[s.charAt(j) - 'a'] = 1;

                if(hash[0] + hash[1] + hash[2] == 3)
                {
                    count += 1 + (n - (j + 1));
                    break;
                }
            }
        }

        return count;
    }
}
