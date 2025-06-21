package arrays.easy;

import java.util.ArrayList;

public class Intersections_In_Given_Sorted_Arrays
{
    public static void main(String[] args) {

        int[] arr1 ={1,2,2,3,3,4,5,6};
        int[] arr2 = {2,3,3,5,6,6,7};

        ArrayList<Integer> ans =  findIntersection(arr1, arr2);

        System.out.println(ans);
    }

    static ArrayList<Integer> findIntersection(int[] arr1, int[] arr2)
    {
        int i = 0;
        int j = 0;

        ArrayList<Integer> al = new ArrayList<>();

        while(i < arr1.length && j < arr2.length)
        {
            if(arr1[i] < arr2[j])
            {
                i++;
            }
            else if(arr2[j] > arr1[i])
            {
                j++;
            }
            else
            {
                al.add(arr1[i]);
                i++;
                j++;
            }
        }
        return al;
    }
}
