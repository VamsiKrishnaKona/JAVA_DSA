package LinkedLists.SinglyLinkedList.deleteNthNodeFromLast;

import LinkedLists.SinglyLinkedList.Node;

public class Optimal
{
    private static Node deleteNthNode(Node head, int N)
    {
        if(head == null || head.next == null) return null;

        Node fast = head;

        for(int i = 0 ; i < N ; i++)
        {
            fast = fast.next;
        }

        if(fast == null) return head.next;

        Node slow = head;

        while(fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5};
        int N = 4;

        Node head = getHead(nums);

        head = deleteNthNode(head, N);

        printLL(head);
    }

    private static Node getHead(int[] nums)
    {
        if(nums.length < 1) return null;

        Node head = new Node(nums[0]);
        Node mover = head;

        for(int i = 1 ; i < nums.length ; i++)
        {
            Node temp = new Node(nums[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    private static void printLL(Node head)
    {
        Node curr = head;
        System.out.print("Head -> ");

        while(curr != null)
        {
            System.out.print(curr.value + " -> ");
            curr = curr.next;
        }

        System.out.print(" Tail");
    }
}
