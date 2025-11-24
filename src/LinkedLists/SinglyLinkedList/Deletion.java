package LinkedLists.SinglyLinkedList;

public class Deletion
{
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

    private static Node deleteHead(Node head)
    {
        if(head == null) return head;
        head = head.next;
        return head;
    }

    private static Node deleteTail(Node head)
    {
        Node curr = head;
        if(curr.next == null || curr == null) return head;

        while(curr.next.next != null)
        {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    private static Node deleteNodeByValue(Node head, int value)
    {
        if(head.value == value)
        {
            head = head.next;
            return head;
        }

        Node prev = head;
        Node curr = head.next;

        while(curr != null)
        {
            if(curr.value == value)
            {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }

        return head;
    }

    private static Node deleteKthNode(Node head, int k)
    {
        if(head == null) return head;

        if(k == 1)
        {
            head = head.next;
            return head;
        }

        Node prev = head;
        Node curr = head.next;
        int nodeIndex = 2;

        while(curr != null)
        {
            if(nodeIndex == k)
            {
                prev.next = curr.next;
            }
            prev = prev.next;
            curr = curr.next;
            nodeIndex += 1;
        }
        return head;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5};

        Node head = getHead(nums);

        //head = deleteNodeByValue(head, 5);

        //head = deleteHead(head);

        //head = deleteTail(head);

        head = deleteKthNode(head, 9);

        printLL(head);
    }
}
