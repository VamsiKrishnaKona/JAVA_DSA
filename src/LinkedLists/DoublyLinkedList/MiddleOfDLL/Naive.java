package LinkedLists.DoublyLinkedList.MiddleOfDLL;

import LinkedLists.DoublyLinkedList.Node;

public class Naive
{
    private static Node numsToDLL(int[] nums)
    {
        if(nums.length == 0) return null;

        Node head = new Node(nums[0]);

        Node prev = head;

        for(int i = 1 ; i < nums.length ; i++)
        {
            Node curr = new Node(nums[i], null, prev);
            prev.next = curr;
            prev = prev.next;
        }

        return head;
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
        System.out.println("Tail");
    }

    private static int size(Node head)
    {
        Node curr = head;
        int count = 0;

        while(curr != null)
        {
            count++;
            curr = curr.next;
        }
        return count;
    }

    private static void printMid(Node head)
    {
        int mid = (size(head) / 2) + 1;
        int idx = 0;
        Node curr = head;
        while(curr != null)
        {
            idx += 1;
            if(idx == mid)
            {
                System.out.println("mid : " + curr.value);
                break;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3, 4, 5};

        Node head = numsToDLL(nums);

        print(head);
        System.out.println("size : " + size(head));
        printMid(head);

    }
}
