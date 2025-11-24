package LinkedLists.SinglyLinkedList.startPointInLoopedLL;

import LinkedLists.SinglyLinkedList.Node;

import java.util.HashMap;

public class Optimal
{
    private static Node detectStartNodeInLoop(Node head)
    {
        if(head == null || head.next == null) return null;

        Node curr = head;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                slow = head;
                while(slow != fast)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
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

        Node ans = detectStartNodeInLoop(head);
        System.out.println(ans.value);
    }
}
