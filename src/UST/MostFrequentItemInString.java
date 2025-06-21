package UST;

import java.util.LinkedHashMap;
import java.util.Map;

public class MostFrequentItemInString
{
    public static String freqItem(String str)
    {
        String lower = str.toLowerCase();
        String[] arr = lower.split(";");

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : arr)
        {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int max = 0;
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            if (entry.getValue() > max)
            {
                max = entry.getValue();
                res = entry.getKey();
            }
        }

        return res;
    }

    public static void main(String[] args)
    {
        String str = "laptop;mobile;mobile;mobile;bed;bed;bed;bed";
        String r = freqItem(str);
        System.out.println(r);
    }
}
