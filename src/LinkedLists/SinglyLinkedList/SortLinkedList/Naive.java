package LinkedLists.SinglyLinkedList.SortLinkedList;

import LinkedLists.SinglyLinkedList.Node;

import java.util.HashSet;
import java.util.Set;

//time : o(2N)
//space : o(n)
public class Naive
{
    public static Node sort(Node head)
    {
        Set<Integer> set = new HashSet<>();

        Node curr = head;

        while(curr != null)
        {
            set.add(curr.value);
            curr = curr.next;
        }

        curr = head;

        for(int i : set)
        {
            curr.value = i;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5, -1, 0};

        Node head = getHead(nums);

        head = sort(head);

        printLL(head);
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
}
