package LinkedLists.SinglyLinkedList.DeleteMiddleNode;

import LinkedLists.SinglyLinkedList.Node;

public class Naive
{
    private static Node deleteMiddleNode(Node head)
    {
        if(head == null || head.next == null) return null;

        int len = 0;

        Node curr = head;

        while(curr != null)
        {
            len++;
            curr = curr.next;
        }

        int mid = (len/2);

        curr = head;

        while(curr != null)
        {
            mid--;

            if(mid == 0)
            {
                break;
            }
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5, 6};

        Node head = getHead(nums);

        head = deleteMiddleNode(head);

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
