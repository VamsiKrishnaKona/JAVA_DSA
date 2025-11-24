package LinkedLists.SinglyLinkedList.detectLoop;

import LinkedLists.SinglyLinkedList.Node;

import java.util.HashMap;
import java.util.Map;

public class Naive
{
    private static boolean detectLoop(Node head)
    {
        Node curr = head;

        if(curr == null || curr.next == null) return false;

        Map<Node, Integer> map = new HashMap<>();

        while(curr != null)
        {
            if(map.containsKey(curr))
            {
                return true;
            }
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            curr = curr.next;
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
        fifth.next = third;

        boolean ans = detectLoop(head);
        System.out.println(ans);
    }

//    private static Node arrayToLinkedList(int[] nums)
//    {
//        Node head = new Node(nums[0]);
//        Node curr = head;
//
//        for(int i = 1 ; i < nums.length ; i++)
//        {
//
//            Node temp = new Node(nums[i]);
//            curr.next = temp;
//            curr = temp;
//        }//        return head;
//    }
//
//    private static void printLL(Node head)
//    {
//        Node curr = head;
//
//        System.out.print("head -> ");
//        while(curr != null)
//        {
//            System.out.print(curr.value + " -> ");
//            curr = curr.next;
//        }
//        System.out.print(" tail");
//    }
}
