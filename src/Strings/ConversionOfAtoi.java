package Strings;

public class ConversionOfAtoi
{
    public static void main(String[] args) {
        String s = "   999 nine hundred and ninty nine   ";

        int ans = atoi(s);

        System.out.println(ans);
    }

    public static int atoi(String s)
    {
        if(s == null) return 0;

        s = s.trim(); //o(n)

        if(s.length() == 0) return 0;

        int sign = 1;
        long ans = 0;

        if(s.charAt(0) == '-') sign = -1;

        int i = 0;

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        if(s.charAt(i) == '+' || s.charAt(i) == '-') i = 1;

        //o(n)
        while(i < s.length())
        {
            if(s.charAt(i) == ' ') break;
            if(s.charAt(i) >= 'A' & s.charAt(i) <= 'Z' || s.charAt(i) >= 'a' && s.charAt(i) <= 'z') break;

            ans = (ans * 10) + s.charAt(i) - '0';

            if(sign == -1 && -1 * ans < min) return min;
            if(sign == 1 && ans > max) return max;

            i++;
        }

        return (int)(sign * ans);
    }
}
