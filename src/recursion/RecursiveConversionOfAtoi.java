package recursion;

public class RecursiveConversionOfAtoi
{
    public static void main(String[] args) {
        String s = "   999 nine hundred and ninty nine   ";

        int ans = atoi(s);

        System.out.println(ans);
    }

    public static int atoi(String s)
    {
        if(s.length() == 0) return 0;

        int i = 0;

        while(i < s.length() && s.charAt(i) == ' ') i++;

        if(i >= s.length()) return 0;

        int sign = 1;
        long ans = 0;

        if(s.charAt(i) == '-') sign = -1;

        if(s.charAt(i) == '+' || s.charAt(i) == '-')
        {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        if(i >= s.charAt(i) || !Character.isDigit(s.charAt(i))) return 0;

        ans = helper(s, i, sign, ans);

        return (int)ans;
    }

    public static long helper(String s, int i, int sign, long ans)
    {
        if(i >= s.length() || Character.isDigit(s.charAt(i))) return ans * sign;

        ans = (ans * 10) + (s.charAt(i) - '0');

        if(ans * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(ans * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return helper(s, i + 1, sign, ans);
    }
}
