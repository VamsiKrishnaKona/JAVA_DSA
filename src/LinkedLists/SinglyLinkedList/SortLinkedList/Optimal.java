package LinkedLists.SinglyLinkedList.SortLinkedList;

import LinkedLists.SinglyLinkedList.Node;

public class Optimal
{
    private static Node merge(Node list1, Node list2)
    {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while(list1 != null && list2 != null)
        {
            if(list1.value <= list2.value)
            {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }
            else
            {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }

        if(list1 != null)
        {
            temp.next = list1;
        }
        else
        {
            temp.next = list2;
        }

        return dummyNode.next;
    }

    public static Node sortLL(Node head)
    {
        if(head == null || head.next == null) return head;

        Node mid = middleOfLL(head);
        Node right = mid.next;
        mid.next = null;
        Node left = head;

        left = sortLL(left);
        right = sortLL(right);

        return merge(left, right);
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 8, 7, 6, 5};

        Node head = getHead(nums);

        head = sortLL(head);

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

    private static Node middleOfLL(Node head)
    {
        if(head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
