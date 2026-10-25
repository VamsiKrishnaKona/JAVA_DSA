package slidingWindow_TwoPointers.numberofSubstringsContainingAllThreeCharacters;

public class BruteForce
{
    public static void main(String[] args)
    {
        String s = "bbacba";
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
                    count++;
                }

            }
        }

        return count;
    }
}
