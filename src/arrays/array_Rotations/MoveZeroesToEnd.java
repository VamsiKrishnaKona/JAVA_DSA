package arrays.array_Rotations;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Scanner;
=======
import java.util.*;
>>>>>>> origin/krishna

public class MoveZeroesToEnd
{
    static ArrayList<Integer> moveZeroesToEnd(ArrayList<Integer> al, int len)
    {
        int j = -1;

        for(int i = 0 ; i < len ; i++)
        {
            if(al.get(i) == 0)
            {
                j = i;
                break;
            }
        }

        if(j == -1)
            return al;

        for(int i = j + 1 ; i < len ; i++)
        {
            if(al.get(i) != 0)
            {
                int temp = al.get(i);
                al.set(i, al.get(j));
                al.set(j, temp);
                j++;
            }
        }
        return al;
    }

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();

        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < len ; i++)
        {
            al.add(sc.nextInt());
        }

        ArrayList<Integer> ans = moveZeroesToEnd(al,len);

        System.out.println(al + " ");

    }
}

