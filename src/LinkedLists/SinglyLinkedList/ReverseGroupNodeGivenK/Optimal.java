package LinkedLists.SinglyLinkedList.ReverseGroupNodeGivenK;

import LinkedLists.SinglyLinkedList.Node;

public class Optimal
{
    private static void reverse(Node head)
    {
        if(head == null || head.next == null) return;

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

    private static Node findKthNode(Node head, int group)
    {
        Node curr = head;
        int k = group;
        k -= 1;
        while(curr != null && k > 0)
        {
            k--;
            curr = curr.next;
        }
        return curr;
    }
    private static Node reverseGroups(Node head, int k)
    {
        if(head == null || head.next == null) return head;

        Node curr = head;
        Node prev = null;

        while(curr != null)
        {
            Node kth = findKthNode(curr, k);

            if(kth == null)
            {
                if(prev != null) prev.next = curr;
                break;
            }

            Node front = kth.next;
            kth.next = null;

            reverse(curr);


            if(curr == head)
            {
                head = kth;
            }
            else
            {
                prev.next = kth;
            }
            prev = curr;
            curr = front;
        }

        return head;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        Node head = getHead(nums);

        head = reverseGroups(head, 3);

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
