package LL.Medium;

public class Middle
{
    public static Node findMiddleNode(Node head)
    {

        if(head == null || head.next == null) return head;
        Node curr = head;

        Node slow = curr;
        Node fast = curr;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3 ,4, 5};

        Node head = arrayToLL(nums);
        printLL(head);

        head = findMiddleNode(head);

        printLL(head);



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
