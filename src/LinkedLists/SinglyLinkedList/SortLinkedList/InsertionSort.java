package LinkedLists.SinglyLinkedList.SortLinkedList;

import LinkedLists.SinglyLinkedList.Node;

public class InsertionSort
{
    public static Node insertionSort(Node head)
    {
        if(head == null || head.next == null) return head;

        Node dummy = new Node(-999, head);
        Node curr = head;

        while(curr.next != null)
        {
            if(curr.next.value >= curr.value)
            {
                curr = curr.next;
            }
            else
            {
                Node insertToBe = curr.next;
                curr.next = insertToBe.next;

                Node pre = dummy;

                while (pre.next.value < insertToBe.value)
                {
                    pre = pre.next;
                }

                insertToBe.next = pre.next;
                pre.next = insertToBe;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5, -1, 0};

        Node head = getHead(nums);

        head = insertionSort(head);

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
