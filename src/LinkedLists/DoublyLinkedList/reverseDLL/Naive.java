package LinkedLists.DoublyLinkedList.reverseDLL;

import LinkedLists.DoublyLinkedList.Node;

import java.util.*;

public class Naive
{
    private static void reverse(Node head)
    {
        Node temp = head;
        Stack<Integer> st = new Stack<>();

        while(temp != null)
        {
            st.add(temp.value);
            temp = temp.next;
        }

        Node curr = head;
        while(curr != null)
        {
            curr.value = st.pop();
            curr = curr.next;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        Node head = numsToDLL(nums);

        reverse(head);

        int size = length(head);
        print(head);
        System.out.println("size : " + size);
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
        if(nums.length == 0) return null;

        Node head = new Node(nums[0], null, null);

        Node prev = head;

        for(int i = 1 ; i < nums.length ; i++)
        {
            Node curr = new Node(nums[i], null, prev);
            prev.next = curr;
            prev = prev.next; //temp
        }
        return head;
    }
}
