package LinkedLists.DoublyLinkedList.removeDuplicateNodes;

import LinkedLists.DoublyLinkedList.Node;

import java.util.HashSet;
import java.util.Set;

public class Naive
{
    private static Node removeDuplicates(Node head)
    {
        if(head == null || head.next == null) return head;

        Set<Integer> set = new HashSet<>();

        Node curr = head;

        while(curr != null)
        {
            set.add(curr.value);
            curr = curr.next;
        }

        Node dummy = new Node(-1);
        curr = dummy;


        for(int i : set)
        {
            Node temp = new Node(i, null, curr);
            curr.next = temp;
            curr = temp;
        }


        return dummy.next;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 1, 1, 2, 3, 3, 4, 5, 9};

        Node head = numsToDLL(nums);

        head = removeDuplicates(head);

        print(head);
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
