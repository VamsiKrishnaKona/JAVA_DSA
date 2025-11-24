package LinkedLists.singlyLL_withChild.flattenLinkedList;

import LinkedLists.singlyLL_withChild.Node;

import java.util.ArrayList;
import java.util.Collections;

public class Naive
{
    public static void main(String[] args)
    {
        Node head = new Node(5);
        Node n1 = new Node(10);
        Node n2 = new Node(19);
        Node n3 = new Node(28);

        Node n4 = new Node(7);
        Node n5 = new Node(20);
        Node n6 = new Node(22);
        Node n7 = new Node(40);

        Node n8 = new Node(8);
        Node n9 = new Node(45);

        //Linking nodes...

        head.next = n1;
        head.child = n4;
        n4.child = n8;

        n1.next = n2;
        n1.child = n5;

        n2.next = n3;
        n2.child = n6;

        n3.child = n7;
        n7.child = n9;

        printList(head);

        head = flattenTheList(head);

        System.out.println();

        PrintChildren(head);
    }

    public static Node flattenTheList(Node head)
    {
        if(head == null || head.next == null && head.child == null) return head;

        ArrayList<Integer> nums = new ArrayList<>();

        Node curr = head;

        while(curr != null)
        {
            if(curr.child != null)
            {
                Node temp = curr;
                while(temp != null)
                {
                    nums.add(temp.value);
                    temp = temp.child;
                }
            }
            else
            {
                nums.add(curr.value);
            }

            curr = curr.next;
        }

        Collections.sort(nums);

        Node dummy = new Node(-1);

        curr = dummy;

        for(int i : nums)
        {
            Node createNode = new Node(i);
            curr.child = createNode;
            curr = createNode;
        }

        return dummy.next;
    }

    public static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.value + " ");
            if (node.child != null) {
                System.out.print("-> child(");
                printList(node.child);
                System.out.print(") ");
            }
            node = node.next;
        }
    }

    public static void PrintChildren(Node head)
    {
        Node curr = head;

        System.out.print("Head -> ");
        while(curr != null)
        {
            System.out.print(" " + curr.value);
            curr = curr.child;
        }
        System.out.print(" -> Tail");
    }
}
