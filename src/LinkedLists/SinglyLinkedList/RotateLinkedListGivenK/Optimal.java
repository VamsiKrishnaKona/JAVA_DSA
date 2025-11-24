package LinkedLists.SinglyLinkedList.RotateLinkedListGivenK;

import LinkedLists.SinglyLinkedList.Node;

public class Optimal
{
    public static Node rotate(Node head, int k)
    {
        if(head == null || head.next == null) return head;

        int len = length(head);

        if(k % len == 0) return head;
         k = k % len;

        Node curr = head;
        Node curr2 = null;

        while(curr != null)
        {
            if(k == 0)
            {
                curr2 = head;
                break;
            }
            k--;
            curr = curr.next;
        }

        while(curr != null && curr.next != null)
        {
            curr = curr.next;
            curr2 = curr2.next;
        }

        if(curr2 != null)
        {

            Node newHead = curr2.next;
            curr2.next = null;
            curr.next = head;
            head = newHead;
        }

        return head;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 15;

        Node head = getHead(nums);

        head = rotate(head, k);

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
