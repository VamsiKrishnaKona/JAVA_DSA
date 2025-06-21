package linearSearch;

public class LinearSearch_String
{
    private static boolean search(String str,  char target)
    {
        if(str.length() == 0)
        {
            return false;
        }

        for(int i = 0 ; i < str.length() ; i++)
        {
            if(target == str.charAt(i))
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        String str = "vamsikrishna";
        char target = 'k';

        System.out.println(search(str,target));

    }
}
