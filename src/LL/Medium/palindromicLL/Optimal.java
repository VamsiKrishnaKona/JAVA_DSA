package LL.Medium.palindromicLL;

import LL.Medium.Node;

public class Optimal
{

    private static int isPalidromic(Node head)
    {
        if(head == null || head.next == null) return 0;

        Node slow = head, fast = head;

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node head2 = reverseLL(slow.next);

        Node curr1 = head;
        Node curr2 = head2;

        while(curr2 != null)
        {
            if(curr1.value != curr2.value) return 1;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return 2;
    }
    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3 ,3, 2, 1, 0};

        Node head = arrayToLL(nums);
        printLL(head);

        int opt = isPalidromic(head);

        if(opt == 0) System.out.println("LinkedList is empty");

        if(opt == 1) System.out.println("LinkedList is not palindromic");

        if(opt == 2) System.out.println("linkedList is palindromic");
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

    public static Node reverseLL(Node head)
    {
        if(head == null || head.next == null) return head;

        Node prev = null;
        Node curr = head;
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
}
