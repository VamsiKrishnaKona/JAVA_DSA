package slidingWindow_TwoPointers.longestRepeatingCharacterReplacement;

public class BruteForce
{
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        int maxLen = findLongestSubstring(s, k);
        System.out.println(maxLen);
    }

    private static int findLongestSubstring(String s, int k)
    {
        int n = s.length();
        int maxLen = 0;

        for(int i = 0 ; i < n ; i++)
        {
            int[] hash = new int[26];
            int maxFreq = 0;
            for(int j = i ; j < n ; j++)
            {
                hash[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);

                int chance = (j - i + 1) - maxFreq;

                if(chance <= k)
                {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                else
                {
                    break;
                }
            }
        }
        return maxLen;
    }
}
