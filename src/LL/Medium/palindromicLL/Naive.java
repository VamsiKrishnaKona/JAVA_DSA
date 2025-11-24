package LL.Medium.palindromicLL;

import LL.Medium.Node;

import java.util.Stack;

public class Naive
{
    private static int isPalidromic(Node head)
    {
        if(head == null || head.next == null) return 0;
        
        Stack<Integer> valueStack = new Stack<Integer>();

        Node curr = head;

        // one iteration n
        while(curr != null)
        {
            valueStack.push(curr.value);
            curr = curr.next;
        }

        curr = head;

        while(curr != null)
        {
            if(curr.value == valueStack.peek())
            {
                curr = curr.next;
                valueStack.pop();
            }
            else
            {
                return 1;
            }
        }

        return 2;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3 ,3, 2, 1};

        Node head = arrayToLL(nums);
        printLL(head);

        int opt = isPalidromic(head);

        if(opt == 0) System.out.println("LinkedList is empty");

        if(opt == 1) System.out.println("LinkedList is not palindromic");

        if(opt == 2) System.out.println("linkedList is palindromic");
    }

    public static Node arrayToLL(int[] nums)
    {
        Node head = new Node(nums[0]);
        Node curr = head;

        for(int i = 1 ; i < nums.length ; i++)
        {
            Node temp = new Node(nums[i]);
            curr.next = temp;
            curr = temp;
        }

        return head;
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
