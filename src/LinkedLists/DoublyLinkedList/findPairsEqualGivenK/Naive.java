package LinkedLists.DoublyLinkedList.findPairsEqualGivenK;

import LinkedLists.DoublyLinkedList.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class Naive
{
    private static ArrayList<ArrayList<Integer>> findPairs(Node head, int k)
    {
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();

        if(head == null || head.next == null)
        {
            return pairs;
        }

        Node curr = head;
        Node front = null;

        while(curr.next != null)
        {
            front = curr.next;

            while(front != null)
            {
                int sum = curr.value + front.value;

                if(sum == k)
                {
                    pairs.add(new ArrayList<>(Arrays.asList(curr.value, front.value)));
                }
                else if(sum > k)
                {
                    break;
                }

                front = front.next;
            }

            curr = curr.next;
        }
        return pairs;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3, 4, 9};
        int k = 5;

        Node head = numsToDLL(nums);

        ArrayList<ArrayList<Integer>> pairs = findPairs(head, k);

        System.out.println(pairs);

        //print(head);
    }


    private static void print(Node head)
    {
        Node curr = head;
        System.out.println();
        System.out.print("Head -> ");
        while(curr != null)
        {
            System.out.print(curr.value + " -> ");
            curr = curr.next;
        }
        System.out.print("Tail");
        System.out.println();
    }

    private static int length(Node head)
    {
        int size = 0;

        Node curr = head;

        while(curr != null)
        {
            size++;
            curr = curr.next;
        }
        return size;
    }

    private static Node numsToDLL(int[] nums)
    {
        if(nums.length <= 0) return null;

        Node head = new Node(nums[0], null, null);

        Node prev = head;

        for(int i = 1 ; i < nums.length ; i++)
        {
            Node temp = new Node(nums[i], null, prev);
            prev.next = temp;
            prev = prev.next; //temp
        }
        return head;
    }
}
