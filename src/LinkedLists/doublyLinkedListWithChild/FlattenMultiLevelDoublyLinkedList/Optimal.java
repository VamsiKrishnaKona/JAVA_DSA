package LinkedLists.doublyLinkedListWithChild.FlattenMultiLevelDoublyLinkedList;

import LinkedLists.doublyLinkedListWithChild.Node;

public class Optimal
{
    private static Node findEnd(Node head)
    {
        Node curr = head;

        while(curr.next != null)
        {
            curr = curr.next;
        }
        return curr;
    }

    private static Node flattenTheLinkedList(Node head)
    {
        if(head == null) return head;
        if(head.next == null && head.child == null) return head;

        Node curr = head;

        while(curr != null)
        {
            if(curr.child != null)
            {


                Node childHead = flattenTheLinkedList(curr.child);
                Node childTail = findEnd(childHead);

                Node front = curr.next;

                curr.next = childHead;
                childHead.prev = curr;

                childTail.next = front;

                if(front != null) front.prev = childTail;

                curr.child = null;
            }

            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args)
    {
        // Create nodes 1..12
        Node n1  = new Node(1);
        Node n2  = new Node(2);
        Node n3  = new Node(3);
        Node n4  = new Node(4);
        Node n5  = new Node(5);
        Node n6  = new Node(6);
        Node n7  = new Node(7);
        Node n8  = new Node(8);
        Node n9  = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        // Top level: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6
        n1.next = n2;

        n2.prev = n1;
        n2.next = n3;

        n3.prev = n2;
        n3.next = n4;

        n4.prev = n3;
        n4.next = n5;

        n5.prev = n4;
        n5.next = n6;

        n6.prev = n5;

        // Second level (child of 3): 7 <-> 8 <-> 9 <-> 10
        n3.child = n7;

        n7.next = n8;

        n8.prev = n7;
        n8.next = n9;

        n9.prev = n8;
        n9.next = n10;

        n10.prev = n9;

        // Third level (child of 8): 11 <-> 12
        n8.child = n11;

        n11.next = n12;
        n12.prev = n11;

        Node head = n1;

        head = flattenTheLinkedList(head);

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
}
