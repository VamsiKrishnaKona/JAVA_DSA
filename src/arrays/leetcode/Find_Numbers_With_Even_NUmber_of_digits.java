package arrays.leetcode;

public class Find_Numbers_With_Even_NUmber_of_digits
{

    private static int checkEvens(int[] arr)
    {
        int count = 0;

        for(int i = 0 ; i < arr.length ; i++)
        {
            int rem = 0, div = 0, inside_count = 0;
            while(arr[i] > 0)
            {
                div = arr[i] % 10;
                arr[i] = arr[i]/10;
                inside_count++;
            }

            if(inside_count%2 == 0)
            {
                count += 1;
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        int[] arr = new int[]{18, 124, 2, 1764, 98, 1};

        int ans = checkEvens(arr);

        System.out.println(ans);

    }
}
