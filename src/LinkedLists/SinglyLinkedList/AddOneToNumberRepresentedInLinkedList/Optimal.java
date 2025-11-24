package LinkedLists.SinglyLinkedList.AddOneToNumberRepresentedInLinkedList;

import LinkedLists.SinglyLinkedList.Node;

public class Optimal
{
    public static int helper(Node head, int carry)
    {
        if(head == null) return carry;

        carry = helper(head.next, carry);

        Node curr = head;

        int val = curr.value + carry;

        if(val < 10)
        {
            curr.value = val;
            carry = 0;
        }
        else
        {
            curr.value = 0;
        }
        return carry;
    }

    public static Node func(Node head)
    {
        if(head == null) return null;

        int carry = helper(head, 1);

        if(carry == 1)
        {
            Node pre = new Node(1, head);
            head = pre;
        }

        return head;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 5, 9};

        Node head = getHead(nums);

        head = func(head);

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
