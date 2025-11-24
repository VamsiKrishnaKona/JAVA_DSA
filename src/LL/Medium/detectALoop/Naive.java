package LL.Medium.detectALoop;

import LL.Medium.Node;

public class Naive
{
    public static void main(String[] args)
    {
        //int[] nums = new int[]{1, 2, 3 ,4, 5};

        //Node head = arrayToLL(nums);

        Node n1 = new Node(1, null);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n3;

        printLL(n1);
    }

    public static void printLL(Node head)
    {
        Node curr = head;

        System.out.print("Head -> ");
        while(curr != null)
        {
            System.out.print(curr.value + " -> ");
            curr = curr.next;
        }
        System.out.print("Tail\n");

    }
}
