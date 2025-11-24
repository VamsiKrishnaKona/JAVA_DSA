package LinkedLists.DoublyLinkedList.DeleteNodeGivenKey;

import LinkedLists.DoublyLinkedList.Node;

public class Optimal
{

    private static Node removeNodesMatchesK(Node head, int k)
    {
        if(head == null) return head;

        Node curr = head;
        Node front = null;
        Node prev = null;

        while(curr != null)
        {
            if(curr.value == k)
            {
                if(curr == head) head = head.next;

                front = curr.next;
                prev = curr.previous;

                if(front != null) front.previous = prev;
                if(prev != null ) prev.next = front;

                curr.next = null ;
                curr.previous = null;

                curr = front;
            }
            else
            {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{10, 4, 10, 10, 6, 10};
        int k = 10;

        Node head = numsToDLL(nums);

        head = removeNodesMatchesK(head, k);

        print(head);
    }


    private static void print(Node head)
    {
        Node curr = head;
        System.out.println();
        System.out.print("Head -> ");
        while(curr != null)
        {
            System.out.print(curr.value + " -> ");
            curr = curr.next;
        }
        System.out.print("Tail");
        System.out.println();
    }

    private static int length(Node head)
    {
        int size = 0;

        Node curr = head;

        while(curr != null)
        {
            size++;
            curr = curr.next;
        }
        return size;
    }

    private static Node numsToDLL(int[] nums)
    {
        if(nums.length <= 0) return null;

        Node head = new Node(nums[0], null, null);

        Node prev = head;

        for(int i = 1 ; i < nums.length ; i++)
        {
            Node temp = new Node(nums[i], null, prev);
            prev.next = temp;
            prev = prev.next; //temp
        }
        return head;
    }


}
