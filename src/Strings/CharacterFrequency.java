package Strings;

import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency
{
    public static void main(String [] args)
    {
        String str = "vamsi krishna";

        freq(str);
        //freqUsingMap(str);
    }

    public static void freq(String str)
    {
        int[] freq = new int[str.length()];

        int i , j;
        char[] s = str.toCharArray();

        for( i = 0 ; i < str.length() ; i++)
        {
            freq[i] = 1;
            for(j = i+1 ; j < str.length() ; j++)
            {
                if(s[i] == s[j])
                {
                    freq[i]++;
                    s[j] = '0';
                }
            }
        }

        for(i = 0 ; i < freq.length ; i++)
        {
            if(s[i] != ' ' && s[i] != '0')
            {
                System.out.println(str.charAt(i) + " : " + freq[i]);
            }
        }
    }

    public static void freqUsingMap(String str)
    {
        HashMap<Character, Integer> map = new HashMap<>();

        char[] s  = str.toCharArray();

        for(int i = 0 ; i < s.length ; i++)
        {
            if(map.containsKey(s[i]))
            {
                map.put(s[i],map.get(s[i]) + 1);
            }
            else
            {
                map.put(s[i],1);
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

    }
}
