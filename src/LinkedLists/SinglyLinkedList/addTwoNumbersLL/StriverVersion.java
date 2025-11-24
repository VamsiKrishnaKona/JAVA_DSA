package LinkedLists.SinglyLinkedList.addTwoNumbersLL;

import LinkedLists.SinglyLinkedList.Node;

public class StriverVersion
{
    public static Node sumLinkedLists(Node head1, Node head2)
    {

        if(head1 == null) return head2;

        if(head2 == null) return head1;

        Node dummy = new Node(-1);
        Node curr = dummy;

        Node c1 = head1;

        Node c2 = head2;

        int carry = 0;

        while(c1 != null || c2 != null)
        {
            int n1 = c1.value;
            int n2 = c2.value;

            int sum = carry;
            if(c1 != null) sum += c1.value;
            if(c2 != null) sum += c2.value;

            Node temp = new Node(sum % 10);
            carry = sum / 10;

            curr.next = temp;
            curr = temp;

            if(c1 != null) c1 = c1.next;
            if(c2 != null) c2 = c2.next;
        }

        if(carry != 0)
        {
            Node temp = new Node(carry);
            curr.next = temp;
            curr = temp;
        }

        return dummy.next;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {2, 4, 3};

        int[] nums2 = {5, 6, 4};

        Node head1 = getHead(nums1);

        Node head2 = getHead(nums2);

        Node sumHead = sumLinkedLists(head1, head2);

        printLL(sumHead);
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
