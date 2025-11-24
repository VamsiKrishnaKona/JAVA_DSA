package LinkedLists.SinglyLinkedList.Reverse;

import LinkedLists.SinglyLinkedList.Node;

public class Optimal_Iterative
{
    private static Node reverse(Node head)
    {
        if(head == null || head.next == null) return head;

        Node curr = head;
        Node prev = null;

        while(curr != null)
        {
            Node front = null;
            if(curr.next != null) front = curr.next;
            else
            {
                curr.next = prev;
                return curr;
            }

            curr.next = prev;
            prev = curr;
            curr = front;
        }
        
        return prev;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5};

        Node head = getHead(nums);

        head = reverse(head);

        printLL(head);
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

    private static int length(Node head)
    {
        int len = 0;

        Node temp = head;

        while(temp != null)
        {
            len += 1;
            temp = temp.next;
        }
        return len;
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
}
