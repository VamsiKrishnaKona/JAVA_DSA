package linearSearch;

public class Operations
{
    public static int linearSearch(int[] arr, int target)
    {
        if(arr.length < 2)
        {
            return 0;
        }

        for(int i = 0 ; i < arr.length ; i++ )
        {
            if(arr[i] == target)
                return i;
        }
        return -1;
    }

    //////////////////////////////////////////////////////////////////////


    private static int min(int[] arr)
    {
        int min = arr[0];

        for(int index = 0 ; index < arr.length ; ++index)
        {
            if(arr[index] < min)
            {
                min = arr[index];
            }
        }
        return min;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{10,-26,13,4,55,36};
        int target = 42;

        //System.out.println(linearSearch(arr,target));
        System.out.println(min(arr));


    }
}
