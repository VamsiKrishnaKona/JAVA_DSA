package LinkedLists.SinglyLinkedList.startPointInLoopedLL;

import LinkedLists.SinglyLinkedList.Node;

import java.util.HashMap;

public class Naive
{
    private static Node detectStartNodeInLoop(Node head)
    {
        if(head == null || head.next == null) return head;

        Node curr = head;

        HashMap<Node , Integer> map = new HashMap<>();

        while(curr != null)
        {
            if(map.containsKey(curr)) return curr;

            map.put(curr, map.getOrDefault(curr, 0) + 1);

            curr = curr.next;
        }
        return head;
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
