package linearSearch;

public class LinearSearch_StringArr
{
    public static boolean linearSearch(String[] arr, String target)
    {
        if(arr.length < 2)
        {
            return false;
        }
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(arr[i].equals(target))
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        String[] arr = new String[]{"vamsi","tulasi","satya","madhu"};
        String target = "deepika";

        boolean ans = linearSearch(arr,target);

        if(ans)
        {
            System.out.println("Element found!");
        }
        else
        {
            System.out.println("Element not found");
        }
    }

}
