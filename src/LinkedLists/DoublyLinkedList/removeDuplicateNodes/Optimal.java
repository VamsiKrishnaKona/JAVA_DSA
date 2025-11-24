package LinkedLists.DoublyLinkedList.removeDuplicateNodes;

import LinkedLists.DoublyLinkedList.Node;

public class Optimal
{
    private static Node removeDuplicates(Node head)
    {
        if(head == null || head.next == null) return head;

        Node curr = head;

        while(curr != null && curr.next != null)
        {
            if(curr.value == curr.next.value)
            {
                Node front = curr.next.next;
                if(front != null) front.previous = curr;
                curr.next = front;
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
        int[] nums = new int[]{1, 1, 1, 2, 3, 3, 4, 5, 9};

        Node head = numsToDLL(nums);

        head = removeDuplicates(head);

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
