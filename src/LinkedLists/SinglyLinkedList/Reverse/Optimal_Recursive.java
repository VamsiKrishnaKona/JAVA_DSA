package LinkedLists.SinglyLinkedList.Reverse;

import LinkedLists.SinglyLinkedList.Node;

public class Optimal_Recursive
{
    private static Node reverseLL(Node head)
    {
        if(head == null || head.next == null) return head;

        Node newHead = reverseLL(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String [] args)
    {
        int[] nums = new int[]{1, 2, 3, 4, 5};

        Node head = arrayToLinkedList(nums);

        head = reverseLL(head);

        printLL(head);
    }

    private static Node arrayToLinkedList(int[] nums)
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

    private static void printLL(Node head)
    {
        Node curr = head;

        System.out.print("head -> ");
        while(curr != null)
        {
            System.out.print(curr.value + " -> ");
            curr = curr.next;
        }
        System.out.print(" tail");
    }
}
