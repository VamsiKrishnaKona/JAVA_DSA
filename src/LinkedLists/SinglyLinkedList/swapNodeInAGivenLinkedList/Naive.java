package LinkedLists.SinglyLinkedList.swapNodeInAGivenLinkedList;

import LinkedLists.SinglyLinkedList.Node;

import java.util.ArrayList;
import java.util.List;

public class Naive
{
    private static Node swap(Node head, int k)
    {
        if(head == null || head.next == null) return head;

        Node curr = head;

        List<Integer> list = new ArrayList<>();

        while(curr != null)
        {
            list.add(curr.value);
            curr = curr.next;
        }

        int a = list.get(k - 1);
        int b = list.get(list.size() - k);

        list.set(k - 1, b);
        list.set(list.size() - k, a);

        curr = head;

        for(int i : list)
        {
            curr.value = i;
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;

        Node head = getHead(nums);

        head = swap(head, k);

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
