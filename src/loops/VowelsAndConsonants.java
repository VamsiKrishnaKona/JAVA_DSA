package loops;

import java.util.Scanner;

public class VowelsAndConsonants
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char c = sc.next().charAt(0);

        if(isVowel(c))
        {
            System.out.println(c+ " True");
        }
        else
        {
            System.out.println(c+ " False");
        }


    }

    public static boolean isVowel(char c)
    {
        if(c == 'a' || c =='e' || c =='i' || c =='o' || c =='u')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
