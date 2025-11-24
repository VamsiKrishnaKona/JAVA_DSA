package LinkedLists.SinglyLinkedList.oddEvenLinkedList;

import LinkedLists.SinglyLinkedList.Node;

public class Optimal
{
    private static Node evenOdd(Node head)
    {
        Node oddNode = head;
        Node evenNode = head.next;
        Node evenHead = evenNode;

        while(evenNode != null && evenNode.next != null)
        {
            oddNode.next = evenNode.next;
            oddNode = evenNode.next;
            evenNode.next = oddNode.next;
            evenNode = oddNode.next;
        }

        oddNode.next = evenHead;

        return head;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5};

        Node head = getHead(nums);

        head = evenOdd(head);

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
