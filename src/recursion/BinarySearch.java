package recursion;

public class BinarySearch
{
    public static void main(String[] args) {

        int[] arr = {1,2,5,6,8,11,15,34};
        int target = 8;

        int ans = binarySearch(arr, target,0, arr.length - 1);

        System.out.println(ans);
    }

    static int binarySearch(int[] arr,int target, int s, int e)
    {
        if(s > e)
        {
            return -1;
        }

        int m = s + (e - s)/2;

        if(arr[m] == target)
        {
            return m;
        }

        if(target < arr[m]){
            return binarySearch(arr, target, s, m-1);
        }

        return binarySearch(arr, target, m+1, e);
    }
}
