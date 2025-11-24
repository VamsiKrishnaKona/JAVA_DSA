package LinkedLists.SinglyLinkedList.LoopLength_InLL;

import LinkedLists.SinglyLinkedList.Node;

public class Optimal
{
    private static int detectLoop(Node head)
    {
        Node curr = head;

        if(curr == null) return 0;

        if(curr.next == null) return 0;

        Node slow = curr;
        Node fast = curr;

        int count = 1;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                return count;
            }
        }
        return 0;
    }

    public static void main(String [] args)
    {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Created a loop by linking 3rd node next to 5th node.
        fifth.next = third;

        int ans = detectLoop(head);
        System.out.println(ans);
    }
}
