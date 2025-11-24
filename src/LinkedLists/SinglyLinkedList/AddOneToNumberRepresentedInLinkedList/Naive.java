package LinkedLists.SinglyLinkedList.AddOneToNumberRepresentedInLinkedList;

import LinkedLists.SinglyLinkedList.Node;

public class Naive
{

    public static Node reverse(Node head)
    {
        if(head == null || head.next == null) return head;

        Node curr = head;
        Node prev = null;

        while(curr != null)
        {
            Node front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return prev;
    }

    private static Node addOneToNumberInLL(Node head)
    {
        if(head == null) return head;

        head = reverse(head);

        int carry = 1;

        Node curr = head;

        while(curr != null && carry != 0)
        {
            int val = curr.value;

            val = val + 1;

            if(val > 9)
            {
                curr.value = 0;
            }
            else
            {
                curr.value = val;
                carry = 0;
            }
            curr = curr.next;
        }

        head = reverse(head);

        if(carry == 1)
        {
            Node pre = new Node(carry);
            pre.next = head;
            head = pre;
        }

        return head;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 9, 9};

        Node head = getHead(nums);

        head = addOneToNumberInLL(head);

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
