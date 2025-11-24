package LinkedLists.SinglyLinkedList.detectLoop;

import LinkedLists.SinglyLinkedList.Node;

public class Optimal
{
    private static boolean detectLoop(Node head)
    {
        Node curr = head;

        if(curr == null || curr.next == null) return false;

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
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
        //fifth.next = third;

        boolean ans = detectLoop(head);
        System.out.println(ans);
    }
}
