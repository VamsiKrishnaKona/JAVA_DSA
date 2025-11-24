package LinkedLists.SinglyLinkedList.DeleteMiddleNode;

import LinkedLists.SinglyLinkedList.Node;

public class Optimal
{
    private static Node deleteMiddleNode(Node head)
    {
        if(head == null || head.next == null) return null;

        //This approach uses extra variable prev.
/*      Node slow = head;
        Node fast = head;
        Node prev = null;

        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

*/

        //this approach don't use extra variable and slightly changes in slow and fast pointer algorithm.
        //slow starts at head node
        //fast starts 2nd place after head.
        Node slow = head;
        Node fast = slow.next.next;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4};

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
