package hashing;

import java.util.*;

public class Hashing
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i = 0 ; i < size ; i++)
        {
            arr[i] = sc.nextInt();
        }

        hash(sc,size,arr);

        sc.close();
    }

    public static void hash(Scanner sc, int size, int[] arr)
    {

        int hashTableSize = 1000000;

        int[] hash = new int[hashTableSize];
        for(int i = 0 ; i < size ; i++)
        {
            hash[arr[i]] += 1;
        }

        int q = sc.nextInt();

        while(q-- != 0)
        {
            int number = sc.nextInt();
            System.out.print(Arrays.toString(new int[] {hash[number]}));
        }
    }
}
