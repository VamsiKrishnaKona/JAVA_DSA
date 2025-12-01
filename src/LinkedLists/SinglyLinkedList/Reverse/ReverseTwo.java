package LinkedLists.SinglyLinkedList.Reverse;

import LinkedLists.SinglyLinkedList.Node;

public class ReverseTwo
{
    private static Node reverseTwo(Node head, int left, int right)
    {
        if(head == null || head.next == null) return head;

        Node curr = head;

        Node startNode = curr;
        Node endNode = curr;

        Node startConnector = null;

        int i = 1;
        int diff = right - left;

        while(i < right)
        {
            i += 1;
            if(i > diff + 1)
            {
                startConnector = startNode;
                startNode = startNode.next;
                endNode = endNode.next;
            }
            else
            {
                endNode = endNode.next;
            }
        }

        Node endConnector = null;

        if(endNode.next != null)
        {
            endConnector = endNode.next;
        }

        endNode.next = null;

        if(startConnector != null) startConnector.next = null;

        reverse(startNode);

        if(startConnector != null)
        {
            startConnector.next = endNode;
        }
        else
        {
            head = endNode;
        }

        startNode.next = endConnector;

        return head;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5};
        int left = 4;
        int right = 5;

        Node head = getHead(nums);

        head = reverseTwo(head, left, right);

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

    private static void reverse(Node head)
    {
        Node curr = head;
        Node prev = null;

        while(curr != null)
        {
            Node front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
    }

}
