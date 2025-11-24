package LinkedLists.SinglyLinkedList.oddEvenLinkedList;

import LinkedLists.SinglyLinkedList.Node;

import java.util.ArrayList;
import java.util.List;

public class Naive
{
    private static Node EvenOdd(Node head)
    {
        List<Integer> list = new ArrayList<>();

        Node temp = head;

        while(temp != null)
        {
            list.add(temp.value);

            if(temp.next != null && temp.next.next != null)
            {
                temp = temp.next.next;
            }
            else
            {
                break;
            }
        }

        temp = head.next;

        while(temp != null && temp.next != null)
        {
            list.add(temp.value);
            temp = temp.next.next;
        }
        if(temp != null) list.add(temp.value);

        Node curr = head;

        System.out.println(list);

//        Enchanced Loop or For each
//        for(int i : list)
//        {
//            curr.value = i;
//            curr = curr.next;
//        }

        //traditional loop
        for(int i = 0 ; i < list.size() ; i++)
        {
            curr.value = list.get(i);
            curr = curr.next;
        }
       return head;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5, 6};

        Node head = getHead(nums);

        head = EvenOdd(head);

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
