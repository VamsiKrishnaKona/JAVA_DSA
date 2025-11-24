package LL.Medium.reverseLL;

import LL.Medium.Node;

public class ReverseLL
{
    public static Node reverseLL(Node head)
    {
        if(head == null || head.next == null) return head;

        Node curr = head;
        Node prev = null;
        Node front = null;

        while(curr != null)
        {
            front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }


    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3 ,4, 5};

        Node head = arrayToLL(nums);
        printLL(head);

        head = reverseLL(head);
        printLL(head);
    }

    public static Node arrayToLL(int[] nums)
    {
        Node head = new Node(nums[0]);
        Node curr = head;

        for(int i = 1 ; i < nums.length ; i++)
        {
            Node temp = new Node(nums[i]);
            curr.next = temp;
            curr = temp;
        }

        return head;
    }

    public static void printLL(Node head)
    {
        Node curr = head;

        System.out.print("Head -> ");
        while(curr != null)
        {
            System.out.print(curr.value + " -> ");
            curr = curr.next;
        }
        System.out.print("Tail\n");

    }
}
