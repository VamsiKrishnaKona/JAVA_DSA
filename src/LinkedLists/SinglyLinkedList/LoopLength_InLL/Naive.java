package LinkedLists.SinglyLinkedList.LoopLength_InLL;

import LinkedLists.SinglyLinkedList.Node;

import java.util.HashMap;
import java.util.Map;

public class Naive
{
    private static int detectLoop(Node head)
    {
        Node curr = head;

        if(curr == null) return 0;

        if(curr.next == null) return 0;

        Map<Node, Integer> map = new HashMap<>();
        int timer = 1;

        while(curr != null)
        {
            if(map.containsKey(curr))
            {
                return timer - map.get(curr);
            }
            map.put(curr, timer);
            curr = curr.next;
            timer++;
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
